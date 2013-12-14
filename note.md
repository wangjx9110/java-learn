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

#NOTE

###1. Error: could not open jvm.cfg
####删除c:\windows\system32\java, c:\windows\system32\javaw, c:\windows\system32\javaws

#Q&A

###1. char和long进行计算时是否得到的类型为long?