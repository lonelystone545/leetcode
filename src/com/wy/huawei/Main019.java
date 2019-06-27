package com.wy.huawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * ip��ַ����
 * ����Ҫ����ѭ��
 */
public class Main019 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b =0;
		int c = 0;
		int d = 0;
		int e = 0;
		int priIp = 0;
		int errorIpOrMaskCode = 0;
		while(sc.hasNext()) {
			String str = sc.nextLine();
			String[] strs = str.split("~");
			String ip = strs[0];
			String maskCode = strs[1];
			//�жϸ�ʽ
			if(!isValidFormat(ip) || !isValidFormat(maskCode)){
				errorIpOrMaskCode ++;
				//����ѭ��
				continue;
			}
			//�ж������Ƿ����
			if(!validMaskCode(maskCode)){
				errorIpOrMaskCode ++;
				continue;
			}
			//�ж�ip����
			String ipStr = ip.substring(0, ip.indexOf("."));
			int ipInt = Integer.parseInt(ipStr);
			if(ipInt >=1 && ipInt <127) {
				a ++;
			} else if(ipInt>=128 && ipInt <192) {
				b ++;
			} else if(ipInt>=192 && ipInt < 224) {
				c ++;
			} else if(ipInt>=224 && ipInt <240) {
				d ++;
			} else if(ipInt >=240 && ipInt < 255) {
				e ++;
			}
			
			//�ж��Ƿ���˽��ip
			String ipSubStr = ip.substring(ip.indexOf(".") + 1);
			String snStr = ipSubStr.substring(0, ipSubStr.indexOf("."));
			int sn = Integer.valueOf(snStr);
			if (ipInt == 10 || (ipInt == 172 && sn >= 16 && sn <= 31) || (ipInt == 192 && ipInt == 168)) {
				priIp++;
			}
		}
		sc.close();
		System.out.printf("%d %d %d %d %d %d %d%n", a, b, c, d, e, errorIpOrMaskCode, priIp);
	}
	
	//ip������ĸ�ʽ�Ƿ�ƥ��
	private static boolean isValidFormat(String ip){
		boolean flag = true;
		if(ip == null || "".equals(ip)) {
			return false;
		}
		//������ֱ�� . ,.��java�������⺬�壬��Ҫת��
		Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
		Matcher matcher = pattern.matcher(ip);
		if(matcher.matches()){
			String[] nums = ip.split("\\.");
			for(String num : nums) {
				int n = Integer.parseInt(num);
				if(n<0 || n >255) {
					flag = false;
					break;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}
	//�ж������Ƿ���ȷ(ǰ��ȫ1 ����ȫ0)
	private static boolean validMaskCode(String maskCode) {
		boolean flag = true;
		String[] nums = maskCode.split("\\.");
		StringBuilder sb = new StringBuilder();
		for(String num : nums) {
			int n = Integer.parseInt(num);
			sb.append(binaryString(n));
		}
		int first0 = sb.indexOf("0");
		int last1 = sb.lastIndexOf("1");
		if(first0 < last1) {
			flag = false;
		}
		
		return flag;
	}
	//������ת��Ϊ��Ӧ�İ�λ������
	private static String binaryString(int n) {
		StringBuilder sb = new StringBuilder();
		int flag = 1 << 7;
		for(int i=0; i<8; i++) {
			int val = (flag & n )== 0 ? 0 : 1;
			sb.append(val);
			n <<=1;
		}
		return sb.toString();
	}
}
