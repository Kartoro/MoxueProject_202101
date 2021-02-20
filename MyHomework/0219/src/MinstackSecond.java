import java.util.ArrayList;
import java.util.List;
//better 用了辅助栈
public class MinstackSecond {
    private List<Integer> data;
    private List<Integer> mindata;
    public static  void main(String[] args){
        MinstackSecond minStack = new MinstackSecond();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.DisplayData();
        System.out.println(minStack.getMin());
        minStack.pop();

        minStack.DisplayData();
        System.out.println(minStack.getMin());
        minStack.top();
        minStack.DisplayData();
        System.out.println(minStack.getMin());
        minStack.getMin();
        minStack.DisplayData();
        System.out.println(minStack.getMin());


    }


    /** initialize your data structure here. */
    public void DisplayData(){
        System.out.println(data);

    }



    /** initialize your data structure here. */
    public MinstackSecond() {
        data = new ArrayList<>();
        mindata = new ArrayList<>();
        mindata.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        data.add(x);

        mindata.add(Math.min(x,mindata.get(mindata.size()-1)));

    }

    public void pop() {
        data.remove(data.size()-1);
        mindata.remove(mindata.size()-1);
    }

    public int top()
    {
        return data.get(data.size()-1);
    }

    public int getMin() {
//        int min = data.get(0);
//
//        for(int i =0; i < data.size(); i++){
//            if(min > data.get(i)){
//                mindata.add(data.get(i));
//                min = data.get(i);
//            }else{
//                mindata.add(min);
//            }
//        }

        return mindata.get(mindata.size()-1);

    }
}

