import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    // 增加
    public static ArrayList<User> addUser(){
        List<User> list = new ArrayList<User>();
        User u = new User();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input no: ");
        u.setNo(sc.nextLine());
        System.out.print("Input name: ");
        u.setName(sc.nextLine());
        System.out.print("Input add: ");
        u.setAdd(sc.nextLine());
        System.out.print("Input age: ");
        u.setAge(sc.nextInt());
        list.add(u);
        return (ArrayList<User>) list;
    }
    // 修改
    public static void updateUser(String name, List<User> list){
        Scanner sc = new Scanner(System.in);
        boolean isExist = false;
        for(int i = 0; i < list.size(); i++){
            if(name.equals(list.get(i).getName())){
                isExist = true;
                System.out.print("输入新 no: ");
                list.get(i).setNo(sc.nextLine());
                System.out.print("输入新name: ");
                list.get(i).setName(sc.nextLine());
                System.out.print("输入新add: ");
                list.get(i).setAdd(sc.nextLine());
                System.out.print("输入新age: ");
                list.get(i).setAge(sc.nextInt());
            }
        }
        if(isExist == false){
            System.out.println("不存在该用户");
        }
    }
    // 查找
    public static void findUser(String name, List<User> list){
        boolean isExist = false;
        for(int i = 0; i < list.size(); i++){
            if(name.equals(list.get(i).getName())){
                isExist = true;
                System.out.println("用户编号: " + list.get(i).getNo()
                        + ". 姓名: " + list.get(i).getName()
                        + ". 地址: " + list.get(i).getAdd()
                        + ". 年龄: " + list.get(i).getAge());
            }
        }
        if(isExist == false){
            System.out.println("不存在该用户");
        }
    }
    // 删除
    public static void delUser(String name, List<User> list) {
        boolean isExist = false;
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName())) {
                isExist = true;
                list.remove(i);
                System.out.println("该用户已删除");
            }
        }
        if (isExist == false) {
            System.out.println("不存在该用户");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> list = new ArrayList<User>();
        int i = 0;
        while(true){
            System.out.println("输入你的选择: 1.增加\t2.查找\t3.修改\t4.删除\t0.退出");
            i = sc.nextInt();
            switch (i) {
            case 1:
                list = addUser();
                break;
            case 2:
                System.out.print("输入要查找的用户名: ");
                String name = sc.next();
                findUser(name, list);
                break;
            case 3:
                System.out.print("输入要修改的用户名: ");
                String n = sc.next();
                updateUser(n, list);  
                break;
            case 4:
                System.out.print("输入要删除的用户名: ");
                String na = sc.next();
                delUser(na, list);
                break;
            case 0:
                System.out.println("程序结束!");
                System.exit(0);
                break;
            }
        }
    }
}
