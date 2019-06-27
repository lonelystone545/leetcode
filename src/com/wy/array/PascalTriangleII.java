package com.wy.array;

import java.util.ArrayList;
import java.util.List;

/*
 * �������  ��ӡrowIndex����
 */
public class PascalTriangleII {
	//����ÿ��һ�У������ж�Ӧ����1�ˣ����Կ���ֱ�Ӵ�ǰ������
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<=rowIndex;i++) {
			res.add(0, 1);
			for(int j=1;j<i;j++) {
				res.set(j, res.get(j)+res.get(j+1));
			}
		}
		return res;
	}
	//�Ӻ���ǰ����
	public List<Integer> getRow(int rowNums) {
		List<Integer> res = new ArrayList<Integer>();
		//��ʼ����һ��Ԫ��Ϊ1
		res.add(1);
		for(int i=0;i<rowNums;i++) {
			for(int j=res.size()-2;j>=0;j--) {
				res.set(j+1, res.get(j)+res.get(j+1));
			}
			//ÿ�����һ����Ϊ1
			res.add(1);
		}
		return res;
	}
}
