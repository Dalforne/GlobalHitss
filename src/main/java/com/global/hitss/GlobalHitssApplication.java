package com.global.hitss;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.global.hitss.constant.ErrorCodeEnum;
import com.global.hitss.exception.BusinessException;

@SpringBootApplication
public class GlobalHitssApplication {

	public static void main(String[] args) throws IOException, BusinessException {
		SpringApplication.run(GlobalHitssApplication.class, args);
		
		System.out.println("\nThe first line of the input contains two space separated integers n (number of posters) and h (Arthur height).");
		System.out.println("The next line contains n space separated integers, denoting the elements of the array wallPoints.");
		System.out.println("The last line contains n space separated integers, denoting the elements of the array lengths.\n\n-->");

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		// Cadastrar a Variável de ambiente "OUTPUT_PATH" ou utilizar o código manual abaixo.
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/temp/teste.txt"));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int h = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> wallPoints = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> lengths = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.validateInput(n, h, wallPoints, lengths);

		int answer = Result.solve(n, h, wallPoints, lengths);
		
		System.out.println("The minimum height of the ladder is "+answer);
		System.out.println("Output Path: "+System.getenv("OUTPUT_PATH"));

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	static class Result {

		/*
		 * Complete the 'solve' function below.
		 *
		 * The function is expected to return an INTEGER. The function accepts following
		 * parameters: 1. INTEGER n, 2. INTEGER h 3. INTEGER_ARRAY wallPoints 4. INTEGER_ARRAY lengths
		 */

		public static Integer solve(Integer n, Integer h, List<Integer> wallPoints, List<Integer> lengths) {
			Integer nrMinLadder = 0;

			for (int i = 0; i < n; i++) {
				double nrHeight = wallPoints.get(i) - (lengths.get(i) * 0.25);
				if (nrHeight > h) {
					Integer nrladderSize = ((int) Math.ceil(nrHeight)) - h;

					if (nrladderSize > nrMinLadder) {
						nrMinLadder = nrladderSize;
					}
				}
			}

			return nrMinLadder;
		}

		public static void validateInput(int n, int h, List<Integer> wallPoints, List<Integer> lengths) throws BusinessException {

			if (!(h >= 1 && h < Math.pow(10, 9))) {
				throw new BusinessException(ErrorCodeEnum.INVALID_ENTRY_HEIGHT.getErrorCode()+"."+ErrorCodeEnum.INVALID_ENTRY_HEIGHT.getErrorMsg(),"h");
			}
			if (!(n >= 1 && n < Math.pow(10, 5))) {
				throw new BusinessException(ErrorCodeEnum.INVALID_NUMBER_POSTERS.getErrorCode()+"."+ErrorCodeEnum.INVALID_NUMBER_POSTERS.getErrorMsg(),"n");
			}

			if(!(wallPoints.size()>0 && wallPoints.size()<=n)) {
				throw new BusinessException(ErrorCodeEnum.INVALID_WALL_POINTS.getErrorCode()+"."+ErrorCodeEnum.INVALID_WALL_POINTS.getErrorMsg(),"n");
			}
				
			for (int i = 0; i < wallPoints.size(); i++) {
				if (!(n >= 1 && n < Math.pow(10, 5))) {
					throw new BusinessException(ErrorCodeEnum.INVALID_WALL_POINTS.getErrorCode()+"."+ErrorCodeEnum.INVALID_WALL_POINTS.getErrorMsg(),"wallPoints");
				}
			}
			
			if(!(lengths.size()>0 && lengths.size()<=n)) {
				throw new BusinessException(ErrorCodeEnum.INVALID_WALL_POINTS.getErrorCode()+"."+ErrorCodeEnum.INVALID_WALL_POINTS.getErrorMsg(),"n");
			}
			
			for (int i = 0; i < lengths.size(); i++) {
				if (!(n >= 1 && n < Math.pow(10, 5))) {
					throw new BusinessException(ErrorCodeEnum.INVALID_LENGTH.getErrorCode()+"."+ErrorCodeEnum.INVALID_LENGTH.getErrorMsg(),"lengths");
				}

			}
			
		}

	}

}
