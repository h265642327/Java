import java.util.*;

//目前出现比较多的问题是学科强制输入6个，然后是学科的输出固定语数英物化生的顺序，非常死板，目前还没有更好的思路
//其次是非常严重的输出不对版的问题，搜索了很多还是没能够解决
//修改也只可以全部数据修改,没有做到指定位置修改
//最重要还是没有可以做成可视化界面,唉
public class Runtime {

    public final static int NUM = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> array = new ArrayList<>();
        ArrayList<SubAve> subject = new ArrayList<>();
        while (true) {
            System.out.println("*******************************************************");
            System.out.println("1：Input record");
            //添加学生信息
            System.out.println("2：Calculate total and average score of every course");
            //计算每门课程的总分和平均分
            System.out.println("3：Calculate total and average score of every student");
//            按每个学生的总得分降序排列
            System.out.println("4：Sort in descending order by total score of every student");
//            按数字升序排序
            System.out.println("5：Sort in ascending order by number");
//            按名称升序排序
            System.out.println("6：Sort in ascending order by name");
//            按号码搜索
            System.out.println("7：Search by ID");
//            按名称搜索
            System.out.println("8：Search by name");
//            计算每个学生的总分和平均分
            System.out.println("9：Statistic analysis for every course");
//            每门课程的统计分析
            System.out.println("10：List record");
//            列出记录
            System.out.println("11：Remove");
//            删除
            System.out.println("12：Revise");
//            修改
            System.out.println("0：Exit");
//            退出
            System.out.println("*******************************************************");
            System.out.println("请输入你的选择");
            String s = sc.nextLine();
            switch (s) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("计算每门课程的总分和平均分");
                    calculate_sub(array, subject);
                    break;
                case "3":
//                    System.out.println("计算每个学生的总分和平均分");
                    calculate_stu(array);
                    break;
                case "4":
//                    按每个学生的总得分降序排列
                    sort_stu(array);
                    break;
                case "5":
//                    按数字升序排序
                    sort_id(array);
                    break;
                case "6":
//                    按名称升序排序
                    sort_name(array);
                    break;
                case "7":
                    search_id(array);
                    break;
                case "8":
                    search_name(array);
                    break;
                case "9":
//                    System.out.println("每门课程的统计分析");
                    show_sub(array);
                    break;
                case "10":
//                    System.out.println("列出记录");
                    show(array);
                    break;
                case"11":
                    remove(array);
                    break;
                case"12":
                    revise(array);
                    break;
                case "0":
                    System.out.println("退出");
                    System.exit(0);
            }
        }

    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学号");
        String a = sc.nextLine();
        if (check(a, array)) {
            Student s = new Student();
            s.setID(a);
            System.out.println("输入姓名");
            s.setName(sc.nextLine());
            System.out.println("输入语文成绩，无成绩输入-1");
            s.setScore(sc.nextDouble(), 0);
            System.out.println("输入数学成绩，无成绩输入-1");
            s.setScore(sc.nextDouble(), 1);
            System.out.println("输入英语成绩，无成绩输入-1");
            s.setScore(sc.nextDouble(), 2);
            System.out.println("输入物理成绩，无成绩输入-1");
            s.setScore(sc.nextDouble(), 3);
            System.out.println("输入化学成绩，无成绩输入-1");
            s.setScore(sc.nextDouble(), 4);
            System.out.println("输入生物成绩，无成绩输入-1");
            s.setScore(sc.nextDouble(), 5);
            array.add(s);
            System.out.println("输入完毕");
        } else {
            System.out.println("输入信息有误，返回界面");
        }
    }

    public static void remove(ArrayList<Student> array) {
        if(array!=null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("输入要删除的学号");
            String a = sc.nextLine();
            if (check(a, array)) {
                System.out.println("输入信息有误，返回界面");
                return;
            }
            for (int k = 0; k < array.size(); k++) {
                if (array.get(k).getID().equals(a)) {
                    array.remove(k);
                    break;
                }
            }

            System.out.println("删除完成");
        }
        else{
            System.out.println("无数据,返回");
        }
    }

    public static void show(ArrayList<Student> array) {
        if (array != null) {
            System.out.println("*******************************************************");
            if (array.size() == 0) {
                System.out.println("没有信息");
            } else {
                System.out.println("学号\t\t\t\t姓名\t\t\t语文\t\t\t数学\t\t\t" +
                        "英语\t\t\t物理\t\t\t化学\t\t\t生物\t\t\t总分\t\t\t平均分");
                for (Student i : array) {
                    System.out.println(i.getID() + "\t" + i.getName() + "\t\t\t" + String.format("%.2f", i.getScore(0))
                            + "\t\t\t" + String.format("%.2f", i.getScore(1)) + "\t\t\t" + String.format("%.2f", i.getScore(2)) + "\t\t\t"
                            + String.format("%.2f", i.getScore(3)) + "\t\t\t" + String.format("%.2f", i.getScore(4)) + "\t\t\t" + String.format("%.2f", i.getScore(5))
                            + "\t\t\t" + String.format("%.2f", i.getAllstu()) + "\t\t\t" + String.format("%.2f", i.getAvestu()));

                }
            }
            System.out.println("*******************************************************");
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void revise(ArrayList<Student> array) {
        if(array!=null) {

            System.out.println("输入学号");
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            if (check(a, array)) {
                System.out.println("输入信息有误，返回界面");
                return;
            }
            int num = 0;
            for (int k = 0; k < array.size(); k++) {
                if (array.get(k).getID().equals(a)) {
                    num = k;
                }
            }
            System.out.println("输入新数据");
            Student m = new Student();
            m.setID(sc.nextLine());
            m.setName(sc.nextLine());

            array.set(num, m);
            System.out.println("修改完成");
        }
        else{
            System.out.println("无数据,返回");
        }
    }

    public static boolean check(String ID, ArrayList<Student> array) {
//        如果有重复的报错
        for (Student i : array) {
            if (ID.equals(i.getID())) {
                return false;
            }
        }
        return true;
    }

    public static void calculate_sub(ArrayList<Student> array, ArrayList<SubAve> subject) {
//        我的不足十分明显，那就是我固定了学科一定有六门

        if (array != null) {
            double[] a = new double[NUM];//总分
//        double[] b = new double[NUM];//平均分
            double[] count = new double[NUM];//学科中有效分数的数量
            for (Student i : array) {
                for (int j = 0; j < NUM; j++) {
                    if (i.getScore(j) >= 0) {
                        count[j]++;
                        a[j] += i.getScore(j);
                    }
                }
            }
//        Add add = new Add();
//        add.setSubjectNumber(count);
//        System.out.println(add.getSubjectNumber(0));
            for (int i = 0; i < NUM; i++) {

                SubAve s = new SubAve();
                s.setSuball(a[i]);
                if (count[i] > 0) {
                    s.setSubave(a[i] / count[i]);
                }

                subject.add(s);
            }
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void calculate_stu(ArrayList<Student> array) {
        if (array != null) {
            double[] a = new double[NUM];
            double count = 0;
            for (int i = 0; i < array.size(); i++) {
                for (int j = 0; j < NUM; j++) {
                    if (array.get(i).getScore(j) >= 0) {
                        count++;
                        a[i] += array.get(i).getScore(j);
                    }

                }
                array.get(i).setAllstu(a[i]);
                array.get(i).setAvestu(a[i] / count);
                count = 0;
            }
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void show_sub(ArrayList<Student> array) {
        if (array != null) {
            double[][] a = new double[5][NUM];
            for (Student i : array) {
                for (int k = 0; k < NUM; k++) {
                    if (i.getScore(k) >= 90) {
                        a[0][k]++;
                    } else if (i.getScore(k) >= 80) {
                        a[1][k]++;
                    } else if (i.getScore(k) >= 70) {
                        a[2][k]++;
                    } else if (i.getScore(k) >= 60) {
                        a[3][k]++;
                    } else {
                        a[4][k]++;
                    }

                }
            }
            double[] count = new double[NUM];
            for (Student i : array) {
                for (int j = 0; j < NUM; j++) {
                    if (i.getScore(j) >= 0) {
                        count[j]++;

                    }
                }
            }

            for (double[] i : a) {
                for (int j = 0; j < NUM; j++) {
                    i[j] = i[j] / count[j] * 100;
                }

            }
            System.out.println("*******************************************************");
            System.out.println("\t\t语文\t\t\t数学\t\t\t英语\t\t\t物理\t\t\t化学\t\t\t生物");
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0:
                        System.out.println("优秀\t\t" + String.format("%.2f", a[i][0]) + "%\t\t" + String.format("%.2f", a[i][1]) + "%\t\t" + String.format("%.2f", a[i][2]) + "%\t\t" + String.format("%.2f", a[i][3]) + "%\t\t" + String.format("%.2f", a[i][4]) + "%\t\t" + String.format("%.2f", a[i][5]) + "%\t\t");
                        break;
                    case 1:
                        System.out.println("良好\t\t" + String.format("%.2f", a[i][0]) + "%\t\t" + String.format("%.2f", a[i][1]) + "%\t\t" + String.format("%.2f", a[i][2]) + "%\t\t" + String.format("%.2f", a[i][3]) + "%\t\t" + String.format("%.2f", a[i][4]) + "%\t\t" + String.format("%.2f", a[i][5]) + "%\t\t");
                        break;
                    case 2:
                        System.out.println("中等\t\t" + String.format("%.2f", a[i][0]) + "%\t\t" + String.format("%.2f", a[i][1]) + "%\t\t" + String.format("%.2f", a[i][2]) + "%\t\t" + String.format("%.2f", a[i][3]) + "%\t\t" + String.format("%.2f", a[i][4]) + "%\t\t" + String.format("%.2f", a[i][5]) + "%\t\t");
                        break;
                    case 3:
                        System.out.println("及格\t\t" + String.format("%.2f", a[i][0]) + "%\t\t" + String.format("%.2f", a[i][1]) + "%\t\t" + String.format("%.2f", a[i][2]) + "%\t\t" + String.format("%.2f", a[i][3]) + "%\t\t" + String.format("%.2f", a[i][4]) + "%\t\t" + String.format("%.2f", a[i][5]) + "%\t\t");
                        break;
                    case 4:
                        System.out.println("不及格\t" + String.format("%.2f", a[i][0]) + "%\t\t" + String.format("%.2f", a[i][1]) + "%\t\t" + String.format("%.2f", a[i][2]) + "%\t\t" + String.format("%.2f", a[i][3]) + "%\t\t" + String.format("%.2f", a[i][4]) + "%\t\t" + String.format("%.2f", a[i][5]) + "%\t\t");
                        break;
                }

            }
            System.out.println("*******************************************************");
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void sort_stu(ArrayList<Student> array) {
        if (array != null) {
            array.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o2.getAllstu(), o1.getAllstu());
                }
            });
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void sort_id(ArrayList<Student> array) {
        if (array != null) {

            array.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getID().compareTo(o2.getID());
                }
            });
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void sort_name(ArrayList<Student> array) {
        if (array != null) {
            array.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void search_name(ArrayList<Student> array) {
        if (array != null) {

            System.out.println("请输入你要寻找的名字");
            Scanner sc = new Scanner(System.in);
            String a;
            a = sc.nextLine();

            int paiMing = 0;
            for (Student i : array) {
                paiMing++;
                if (a.equals(i.getName())) {
                    System.out.println("*******************************************************");
                    System.out.println("排名\t\t\t学号\t\t\t姓名\t\t语文\t\t数学\t\t" +
                            "英语\t\t物理\t\t化学\t\t生物\t\t总分\t\t平均分");
                    System.out.println(paiMing + "\t\t\t" + i.getID() + "\t\t\t" + i.getName() + "\t\t" + String.format("%.2f", i.getScore(0))
                            + "\t\t" + String.format("%.2f", i.getScore(1)) + "\t\t" + String.format("%.2f", i.getScore(2)) + "\t\t"
                            + String.format("%.2f", i.getScore(3)) + "\t\t" + String.format("%.2f", i.getScore(4)) + "\t\t" + String.format("%.2f", i.getScore(5))
                            + "\t\t" + String.format("%.2f", i.getAllstu()) + "\t\t" + String.format("%.2f", i.getAvestu()));
                    System.out.println("*******************************************************");
                    break;
                }
            }
        } else {
            System.out.println("无数据，返回");
        }
    }

    public static void search_id(ArrayList<Student> array) {
        if (array != null) {
            System.out.println("请输入你要寻找的学号");
            Scanner sc = new Scanner(System.in);
            String a;
            int paiMing = 0;
            a = sc.nextLine();
            for (Student i : array) {
                paiMing++;
                if (a.equals(i.getID())) {
                    System.out.println("*******************************************************");
                    System.out.println("排名\t\t\t学号\t\t\t姓名\t\t语文\t\t数学\t\t" +
                            "英语\t\t物理\t\t化学\t\t生物\t\t总分\t\t平均分");
                    System.out.println(paiMing + "\t\t\t" + i.getID() + "\t\t\t" + i.getName() + "\t\t" + String.format("%.2f", i.getScore(0))
                            + "\t\t" + String.format("%.2f", i.getScore(1)) + "\t\t" + String.format("%.2f", i.getScore(2)) + "\t\t"
                            + String.format("%.2f", i.getScore(3)) + "\t\t" + String.format("%.2f", i.getScore(4)) + "\t\t" + String.format("%.2f", i.getScore(5))
                            + "\t\t" + String.format("%.2f", i.getAllstu()) + "\t\t" + String.format("%.2f", i.getAvestu()));
                    System.out.println("*******************************************************");
                    break;
                }
            }
        } else {
            System.out.println("无数据，返回");
        }
    }
}

