import java.io.IOException;
import java.util.List;

public class run {
    public static void main(String[] args){
        test testValue = new test();

//        System.out.println(testValue.shuixianhua(153));
//
//        System.out.println(testValue.duoshuyuansu(new int[]{1, 2, 2, 2, 2}));
        System.out.println(testValue.isValid("{[()}}"));
    }
}
