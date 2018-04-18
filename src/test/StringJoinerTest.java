package test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerTest {

	public static void main(String[] args) {
		List<Long> idList = Arrays.asList(31L, 32L, 33L);
		// ?,?,?
		String result = join(idList);
		System.out.println(result);
		
		idList = Arrays.asList(31L, 32L);
		// ?,?
		System.out.println(join(idList));
		
		// 空list in ()
//		System.out.println(join(Arrays.asList()));
		
		// StringJoiner
		StringJoiner joiner = new StringJoiner(",");
		for (Long id : idList) {
			joiner.add("?");
		}
		System.out.println(joiner.toString());
		
		// 如何变成[31,32]
		StringJoiner joiner2 = new StringJoiner(",", "[", "]");
		for (Long id : idList) {
			joiner2.add(id.toString());
		}
		System.out.println(joiner2.toString());
	}

	private static String join(List<Long> idList) {
		String result = "";
		for (Long id : idList) {
			result += "?,";
		}
		result = result.substring(0, 0 + result.length() - 1);
		return result;
	}
}
