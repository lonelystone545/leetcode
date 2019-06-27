package com.wy.array;

/*
 *  You are given an n x n 2D matrix representing an image.
	Rotate the image by 90 degrees (clockwise).
	Follow up:
	Could you do this in-place?
 */
public class RotateImage {
	
	//先旋转最外面一层，再旋转里面的层  注意：四个角的不应该重复旋转，故应该最大为n-2
	public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length<2) return;
        
        int n = matrix.length;
        for(int i=0;i<n-1;i++) {
        	for(int j=i;j<n-1-i;j++) {
        		//旋转90度，横坐标变为纵坐标
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[n-1-j][i];
        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        		matrix[j][n-1-i] = tmp;
        		
        	}
        }
    }
	
	//比较容易理解的做法
	//先主对角线进行交换，然后第一列和最后一列交换，第二列和倒数第二列交换
	public void rotate2(int[][] matrix) {
		if(matrix==null || matrix.length<2) return;
		int n = matrix.length;
		//主对角线交换
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

			}
		}
		//列列交换
		for(int i =0 ; i<n; i++){
            for(int j = 0; j<n/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }

	}
	
	//先沿着副对角线交换，再沿水平中线翻转
	public void rotate3(int[][] matrix) {
		if(matrix==null || matrix.length<2) return;
		int n = matrix.length;
		//副对角线交换
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
			}
		}
		//水平中线
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
