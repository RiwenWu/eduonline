package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class StringToListUtil {

	@Test
	public void stringToListTset() {
		String str = "12,12,12";
		List<String> temp_list = stringToList(str);
		for (String s : temp_list) {
			System.out.println(s);
		}
	}
	
	@Test
	public void randomIntTest() {
		String str = randomInt(12);
		System.out.println(str);
	}
	
	private List<String> stringToList(String strs) {
		String[] str = strs.split(",");
		List<String> list = new ArrayList<String>();
		for(int i =0 ; i<str.length; i++) {
			if(findSame(list, str[i])) {
				continue;
			} else {
				list.add(str[i]);
			}
		}
		return list;
	}
	
	private boolean findSame(List<String> list, String str) {
		for(int i = 0; i <list.size() ; i++) {
			if(list.get(i).equals(str)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public static final String randomInt(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = "0123456789".toCharArray();

		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
		}
		return new String(randBuffer);
	}
}
