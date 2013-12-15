#CONCLUSION

##第二章

###Java的基本数据类型
####基本数据类型: 逻辑(boolean), 整数(byte, short, int, long), 字符(char), 浮点类型(float[常数后面要加F], double)

####观察一个字符在UNICODE字符集中的顺序位置, 必须使用INT类型显式转换. 例: (int)'a', 不能使用short, 因为short最高位是符号位

####数据类型的转换: 1.低->高: 自动 2.高->低: 显式 3.整数赋给byte, short, int, long如果超过范围: 显式

###Java的数组
####Java允许使用int型变量指定数组大小, 例如: int size = 20; double test[] = new double[size];
####数组每层指定一个实体即可, 例如二维数组 int test[][] = new int[3][]; 这层只指定一维的大小即可
####数组有个.length属性
####初始化用{}, 例如: float a[] = {1.2f, 12.0f, 32.5f};

##第三章

###运算符 & 表达式
####Java按运算符两边操作数最高精度保留结果(除法时注意)
####char和整型数据运算结果的精度是INT型数据的精度(byte x = 7; char ch = 'B' + x; 是不对的, 要改成 char ch = (char)('B' + x);)

####IMP: char类型和float类型计算后得float类型, 符合第一条计算取两侧最高精度, 只有整型时特殊(小于int的都进到int, long没有进行测试, 推测为long)

####关系运算符 返回: BOOLEAN 操作数: 数值型即可(char可以转换成数字UNICODE码, 也算, 布尔就不行, 所以基本类型中只有布尔不能作为关系运算符的操作数)

####逻辑运算符 返回: BOOLEAN 操作数: BOOLEAN

####位运算符 (1)按位与(&) a & (all)0 = (all)0, a & (all)1 = a (2)按位或(|) a | (all)0 = a, a | (all)1 = (all)1 (3)按位取反(~) (4)按位异或(^) a ^ 0 = a, a ^ 1 取反, a ^ a 置空 IMP: a = a ^ b ^ b (连续两次和同一个数异或得原值) 0 ^ 1 -> 1, 1 ^ 1 -> 0


##第四章

###类

    类
        类声明
        类体
            变量
                成员变量: 整个类内有效
                    实例变量
                    类变量(静态变量, 加static关键字)
                局部变量: 定义它的方法内有效
            方法
                构成:
                方法声明
                方法体
                种类:
                实例方法
                类方法

####局部变量和成员变量的名字相同, 成员变量被屏蔽, 如果想使用成员变量要加`this`关键字
####方法重载: 一个类中有多个相同名字的方法, 但参数必须不同(只靠参数(类型 | 个数)来区别不同)
####构造方法(函数): 名字: 同类名完全相同 类型: 无类型!   TIPS: 构造方法可以重载

####IMP: 构造方法是特殊方法, 不能用static修饰构造方法

####访问范围: 实例方法 -> (类变量, 实例变量, 类方法, 实例方法 [即类体中的任何东西])  类方法 -> (类变量, 类方法 [即只能访问static的])

###对象

####默认构造函数: 如果类体中有构造函数则没有默认的, 如果没有构造函数则会有一个默认的无参构造函数

####成员变量如果没有赋值, 构造时会自动初始化赋值, 局部变量如果没有赋值, 是不能使用的

####传值..传值..

###static关键字

    实例变量(不可以直接通过类名访问)
        创建对象时分配内存
    类变量(可直接可以通过类名访问)
        创建类(类加载到内存时)分配内存
    实例方法(只能被对象调用, 可以操作实例 & 类)
        创建第一个实例时分配入口地址, 之后创建的对象依旧使用(共享)这个地址, 所有对象都不存在时方法的入口才被取消
    类方法(既可以通过对象调用也可以通过类名调用, 不可以操作实例)
        创建类时分配入口地址

###this关键字
    this可以出现在实例方法和构造方法中, 但不能出现在类方法中, 因为this代表当前调用方法的对象, 类方法可以用类调用.
    this可以使用类和实例的方法和变量

###包

####包名 (package)
#####1.一个合法的标识符
#####2.若干个标识符加"." (加"."的包名, 必须有对应的目录结构) [个人理解: 包有一种命名空间的感觉, 在一个包内不能有重名的类, 然后编译后会有.class文件, 如果在一个文件夹中有多个重名.class文件时不科学的, 所以用文件夹的结构来进行包的映射]

####import语句
#####package -> import -> class
#####如果程序当前目录中某个无名包类和程序引入的包中的某个类重名, 使用无名包中的类, 要使用引入的要写全称 (即无名包中的类会屏蔽引入包中的类)
#####IMP: 引入的包中可以使用的类必须是包中的公共(public)类

###TIPS: 同一个包中友好就是PUBLIC, 不同一个包中友好就是PRIVATE

####访问权限<对象的访问权限> <主要还是说用`.`能不能获取> [一个类创建了一个对象之后, 这个对象操作自己的变量和使用类中的方法是是有一定限制的]
#####访问权限是指对象能否通过`.`运算法操作自己的变量过使用类中的方法
#####PRIVATE : 在类外部的对象不可引用, 用类名使用`.`引用类方法也是不行的
#####PUBLIC : 在任何一个类中用该类创建的对象都可以访问自己的PUBLIC变量和方法
#####友好[什么也不写] : 同一个包中PUBLIC, 即都可以访问. 不在同一个包中(用IMPORT引入的), PRIVATE, 即在另外一个包中建立的对象不能访问
#####PROTECTED : 同友好的一样 <但在继承上有区别>

#####类的修饰: PUBLIC & 不写(即友好的)
#####PUBLIC的类在任何一个另外的类中都可以创建对象
#####友好的类只能在同包中的类中创建对象

####类的继承
#####子类: extends, 没有显式说明的类都是继承自Object

    子类的继承性
        子类和父类在同一个包中: 不继承父类 PRIVATE
        子类和父类不在同一个包中: 不继承父类 PRIVATE & 友好

#####PROTECTED(使用): 在其他类中创建的对象访问其PROTECTED属性, 如果该类最初声明PROTECTED变量的地方同包则可以访问, 否则不可
#####重写父类方法时, 不可以降低访问权限

#####final关键字: 修饰类, 成员变量 & 方法及其中的参数
#####FINAL类: 不能被继承
#####FINAL方法: 方法不能被重写
#####FINAL变量: 常量(必须有初值)
#####FINAL参数: 参数指不能被改变

####上转型对象
#####上转型对象强制转换成子类对象时, 将恢复子类功能.

####abstract类 & abstract方法
1. abstract类可以否abstract方法, a方法不允许实现, 并且不允许用final修饰, 因为要被继承实现(子类必须实现其父a类的a方法)
2. abstract类不能用new运算符创建对象, 因为其中的a方法都没有实现

#####一个abstract类关心的是子类是否具有某种功能, 并不关心具体行为, 行为由子类实现, 其强制子类必须给出这些方法的具体实现

####SUPER关键字
1. SUPER调用父类构造方法: 子类不继承父类的构造方法, 如果子类想使用父类的构造方法, 在子类构造方法的第一句调用super函数, 即代表父类构造方法.
#####TIPS: 如果子类构造函数中没有使用super则默认使用无参的super(), 所以如果父类显式写了构造函数, 最好有个w无参构造函数
2. SUPER调用隐藏的成员变量和方法: super.x; super.play();

####接口(克服单继承) <与类很像, 分接口声明和接口体>

    接口
        接口声明
        接口体
            常量!!定义
            方法定义(只进行方法声明, 用`;`结尾, 同abstract方法相同)

####实现接口的方法要用public修饰 [接口中方法默认public abstract, 常量默认public static, 可以用`接口名.常量`]
####public interface
####接口回调: 上转型
####接口做参数: 同接口回调

##第五章

####1. `String s = new String("This is a string..")`
####2. `Strings = new String(s);`
####3. `String s = new String(char a[][, int startIndex, int count])`

####字符串变量是使用的地址, 赋值赋地址

####字符串的常用方法(s.方法即可)
#####(1) int length()

#####(2) boolean equals(String s) 比较实体的值是否相同, 而不是引用 
         boolean equalsIgnoreCase(String s)

#####(3) boolean startsWith(String perfix[, int startIndex]) 
         boolean endsWith(String s)

#####(4) boolean regionMatches(int originStart, String targetString, int targetStart, int bothLength);
#####匹配两个字符串范围是否相同, 源字符串范围originStart开始, 长度为bothLength, 目标字符串targetString, 范围targetStart开始, 长度为bothLength

#####(5) int compareTo(String s) 按字典序排序, 等于s返回0, 大于s返回正值, 小于s返回负值 
         int compareToIgnoreCase(String s)

#####(6) int indexOf(String s[, int startIndex]) 返回第一次匹配位置, 没有返回-1
         int lastIndexOf(String s)

#####(7) String substring(int startIndex[, int endIndex])

#####(8) String replaceAll(String oldString, String newString)
         String replaceFirst(String oldString, String newString)

#####(9) String trim()

####字符串与基本数据的相互转化
####字符串 -> 数字
    
    Integer.parseInt(String s) 类似有Byte, Short, Int, Long, Float, Double

####数字 -> 字符串
    
    String.valueOf(...);

####整数的各种进制的字符串
    
    Long.toBinarySting(Long i)
    Long.toOctalString(Long i)
    Long.toHexString(Long i)
    Long.toString(Long i, int p) p为进制

####StringTokenizer类

    import java.util.*;
    class S {
        public static void main(String args[]) {
            String s = "This is a test string";
            StringTokenizer st = new StringTokenizer(s, " ,");
            String length = st.countTokens();
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                String cnt = st.countTokens();
            }
        }
    }

####StringBuffer类(可修改字符串序列)
#####SAMPLE 

    StringBuffer s = new StringBuffer("This is a test string");
    s.append(" string add to s");

#####构造方法

    StringBuffer() -> 分配16个字符, 多了自动分配
    StringBuffer(int size) -> size个字符
    StringBuffer(String s) -> s + 16个字符
    
    append();
    charAt(int index);
    setCharAt(int index, char ch);
    insert(int index, String s);
    reverse();
    delete(int startIndex, int endIndex);
    replace(int startIndex, int endIndex, String str);

#####正则表达式
    
    boolean matches(String reg)
    String reg = "\\w{1,}";
    String str = "This is a test message..";
    str.matches(reg);

##第九章

###线程的状态与生命周期
####P227
####线程生命周期: 新建 -> 运行(start, run) -> 中断 -> 结束

####java使用Thread类及其子类的对象表示进程

####start()加入CPU循环
####获取CPU控制权时执行run(), 所以必须在子类重写父类的run()

####中断的四种原因: 
####1. CPU切换 2. 调用sleep()[进入阻塞状态, 一定毫秒后重新加入队列] 3.调用wait()[进入阻塞状态, 有notify()时重新加入事件队列] 4.某个操作进入阻塞状态(如读写操作, 完成后进入队列)

####结束: 1. run()方法OK. 2.线程被提前结束




    



#NOTE

###1. Error: could not open jvm.cfg
####删除c:\windows\system32\java, c:\windows\system32\javaw, c:\windows\system32\javaws

#Q&A

###1. char和long进行计算时是否得到的类型为long?

###2. 当方法类型为void时, `return;` 或者不写 `return;` 语句是否都可以?
###A: 可以, 写不写return都行.

###3. 无名包是什么?
###A: 源文件中定义命名的类在同一个包中, 但该包没有名字.

###4. 一个源文件有一个无名包?

###5. 包名必须和文件名一样吗?
###A: 嗯, 必须一样, 但不区分大小写

###6. 是否一个类只能在一个包中?(即一个源文件只能有一个package语句吗?)

###7. 一个类内部建立一个自己类型的对象其PRIVATE是否可以访问?
###A: 可以, 只要在类内, PRIVATE都可以被访问