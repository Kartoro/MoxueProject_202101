//import java.util.ArrayList;
//import java.util.List;
//借助了min中间值
//class MinStackOne {
//    private List<Integer> data;
//    public static void main(String[] args){
//        MinStackOne minStack = new MinStackOne();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();
//        minStack.DisplayData();
//        System.out.println(minStack.getMin());
//        minStack.pop();
//
//        minStack.DisplayData();
//        System.out.println(minStack.getMin());
//        minStack.top();
//        minStack.DisplayData();
//        System.out.println(minStack.getMin());
//        minStack.getMin();
//        minStack.DisplayData();
//        System.out.println(minStack.getMin());
//
//
//    }
//
//
//    /** initialize your data structure here. */
//    public void DisplayData(){
//        System.out.println(data);
//
//    }    public MinStackOne() {
//        data = new ArrayList<>();
//
//    }
//
//    public void push(int x) {
//        data.add(x);
//    }
//
//    public void pop() {
//        data.remove(data.size()-1);
//
//    }
//
//    public int top() {
//        return data.get(data.size()-1);
//    }
//
//    public int getMin() {
//        int min = data.get(data.size()-1);
//        for(int i =0; i < data.size(); i++){
//            if(min > data.get(i)){
//                min = data.get(i);
//            }
//        }
//        return min;
//    }
//}