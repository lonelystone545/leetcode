package com.wy.array;

/*
 *  You are given an n x n 2D matrix representing an image.
	Rotate the image by 90 degrees (clockwise).
	Follow up:
	Could you do this in-place?
 */
public class RotateImage {
	
	//����ת������һ�㣬����ת����Ĳ�  ע�⣺�ĸ��ǵĲ�Ӧ���ظ���ת����Ӧ�����Ϊn-2
	public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length<2) return;
        
        int n = matrix.length;
        for(int i=0;i<n-1;i++) {
        	for(int j=i;j<n-1-i;j++) {
        		//��ת90�ȣ��������Ϊ������
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n-1-j][i];
        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        		matrix[j][n-1-i] = tmp;
        		
        	}
        }
    }
	
	//�Ƚ�������������
	//�����Խ��߽��н�����Ȼ���һ�к����һ�н������ڶ��к͵����ڶ��н���
	public void rotate2(int[][] matrix) {
		if(matrix==null || matrix.length<2) return;
		int n = matrix.length;
		//���Խ��߽���
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

			}
		}
		//���н���
		for(int i =0 ; i<n; i++){
            for(int j = 0; j<n/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }

	}
	
	//�����Ÿ��Խ��߽���������ˮƽ���߷�ת
	public void rotate3(int[][] matrix) {
		if(matrix==null || matrix.length<2) return;
		int n = matrix.length;
		//���Խ��߽���
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
			}
		}
		//ˮƽ����
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<n;j++) {
				int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
			}
		}
	}
}
