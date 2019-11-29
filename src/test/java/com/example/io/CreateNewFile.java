package com.example.io;

/**
 * @author chendesheng
 * @create 2019/9/18 10:53
 */
public class CreateNewFile {

    private String path;

    private String fileName;

    /**
     * 无参构造器
     */
    public CreateNewFile(){

    }

    /**
     * 有参构造器
     * @param path
     * @param fileName
     */
    public CreateNewFile(String path, String fileName){
        this.path = path;
        this.fileName = fileName;
    }


    public static void main(String[] args) {


        int a,b,c;
        a=b=c=10;

        int left=10;
        int right=5;

        boolean flag = left++>12 && right--<5;

        int t = 5 & 9;

        int number=10;
        number=number+=12/10;
        System.out.println(number);





    }


}
