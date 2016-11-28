package coinsV2developed;

import java.util.HashSet;
import java.util.Set;

public class CoinCalculator {

	public double calculate(Set<Shape> set) {
		double count = 0;
		for (Shape shape : set) {

			count += shape.calculateRealValue();
		}
		return Math.floor(1000 * count) / 1000;

	}

	public static Shape[][] crack(int num, Shape[] input) {
		Shape[][] result = new Shape[(int) Math.pow(input.length, num)][];
		int[] actualIndexArr = new int[num];
		for (int j = 0; j < result.length; j++) {
			Shape[] actualArr = new Shape[num];
			for (int i = 0; i < actualIndexArr.length; i++) {
				actualArr[i] = input[actualIndexArr[i]];
			}
			result[j] = actualArr;
			for (int i = actualIndexArr.length - 1; i >= 0; i--) {
				actualIndexArr[i]++;
				if (actualIndexArr[i] != input.length) {
					break;
				}
				actualIndexArr[i] = 0;
			}
		}
		return result;
	}

	public Shape[] getCoins(double amount, Set<Shape> coinSet) {
		if (coinSet.size() < 5) {
			throw new RuntimeException("Not enough coins!(Min. 5 coins!)");
		}

		Shape[] coinArray = new Shape[coinSet.size()];
		int i = 0;
		for (Shape shape : coinSet) {
			coinArray[i] = shape;
			i++;
		}

		Shape[][] allVariations = crack(5, coinArray);

		for (Shape[] shapes : allVariations) {
			Set<Shape> shapeSet = new HashSet<>();
			for (Shape shape : shapes) {
				shapeSet.add(shape);
			}

			double actualAmount = calculate(shapeSet);
			if (Math.abs(actualAmount - amount) < 0.001) {
				return shapes;
			}
		}

		return null;
	}

}