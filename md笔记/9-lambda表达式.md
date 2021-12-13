# lambda表达式



## 一、Comparable接口

Arrays类中的sort方法承诺可以对对象数组进行排序，但要求满足下面这个条件：**对象所属的类必须实现Comparable接口**。



```java
public interface Comparable
{
    int comparaTo(Object other);
}
```

在JAVA 5中，Comparable接口已经提升为一个泛型类型。

```java
public interface Comparable<T>
{
    int comparaTo(T other);
}
```



现在，假设希望使用Arrays类的sort方法对Employee对象数组进行排序，Employee类就必须实现Comparable接口。

```java
public class Employee implements Comparable<Employee>{

    String name;
    double salary;
    
    //省略getter和setter和构造方法

//    public int compareTo(Object o) {
//        Employee other = (Employee) o;
//        return Double.compare(salary, other.salary);
//    }

	//使用泛型接口后
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
```



为什么不能直接在Employee类提供一个compareTo方法，而必须实现Comparable接口呢？主要原因在于Java程序设计语言是一种强类型（strongly typed）语言。在调用方法的时候，编译器要能检查这个方法确实存在。



测试排序1

```java
@Test
public void test() {
    Employee[] employees = new Employee[3];
    employees[0] = new Employee("a", 200);
    employees[1] = new Employee("b", 100);
    employees[2] = new Employee("c", 300);

    Arrays.sort(employees);

    for (Employee employee : employees) {
        System.out.println(employee.getName());
    }
    //结果：b a c
}
```



## 二、Comparator接口

在前面，我们已经了解了如何对一个对象数组进行排序，前提是这些对象是实现了Comparable接口的类的实例。例如，可以对一个字符串数组进行排序，因为String类实现了Comparable<String>，而且String.compareTo方法可以按字典顺序比较字符串。



但是现在我们希望按长度递增的顺序对字符串进行排序，肯定不能让String类用两种不同的方式实现compareTo方法，而且String类也不应由我们来修改。



要处理这种情况，Arrays.sort方法还有第二个版本，有一个数组和一个比较器(Comparator)作为参数，比较器是实现了Comparator接口的类的实例。

```java
public interface Comparator<T>
{
    int compare(T first, T second);
}
```



现在创建一个实现Comparator接口的类

```java
public class LengthComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
```



测试排序2

```java
@Test
public void test() {
    String[] friends = {"Peter", "Paul", "Mary12312321"};
    LengthComparator comp = new LengthComparator();
    //为sort方法传入一个LengthComparator对象
    Arrays.sort(friends, comp);
    
    for (String friend : friends) {
        System.out.println(friend);
    }
    //结果 Paul Peter Mary12312321
}
```



## 三、lambda表达式

从上面的例子2来看，可以向sort方法传入一个Comparator对象：

```java
public class LengthComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

···
    
Arrays.sort(strings, new LengthComparator());
```



这是将一个代码块传递到某个对象，这块代码来检查一个字符串是否比另一个字符串短。这里计算：

```java
first.length - second.length();
```



first和second是什么？它们都是字符串。Java是一种强类型语言，所以我们还要指定它们的类型：

```java
(String first, String second) -> first.length() - second.length();
```



这就是第一个lambda表达式。lambda表达式就是一个代码块，以及必须传入代码的变量规范。



- Arrays.sort方法需要两个参数，一个是比较的对象数组，另一个是“实现了Comparator接口的对象“

- lambda表达式的说明：对于只有一个抽象方法的接口，**需要这种接口的对象时**，就可以提供一个lambda表达式

- 所以sort的第二个参数，正好符合上述定义



所以测试2写成lambda表达式：

```java
@Test
public void test() {
    String[] friends = {"Peter", "Paul", "Mary12312321"};
   
    Arrays.sort(friends, (first, second) -> first.length() - second.length());
    
    for (String friend : friends) {
        System.out.println(friend);
    }
    //结果 Paul Peter Mary12312321
}
```



## 四、函数式接口



函数式接口：只有一个抽象方法的接口，如上述的Comparator接口，只有一个抽象方法compare(T o1, T o2)

Java API在java.util.function包中定义了很多非常通用的函数式接口：

- BiFunction<T, U, R>描述了参数类型为T和U，返回类型为R的函数；

- Predicate<T>{boolean test(T t); }
- Supplier<T>{T get(); }供应者用于实现懒计算



## 五、方法引用

有时，lambda表达式仅仅涉及一个方法，例如，假设希望只要出现一个定时器事件就打印这个事件对象：

``` java
var timer = new Timer(1000, event -> System.out.println(event));
```

但是，如果直接把println方法传递到Timer构造器就更好了。具体做法如下：

```java
var timer = new Timer(100, System.out::println);
```



表达式System.out::println是一个**方法引用（method reference）**，它指示编译器生成一个函数式接口的实例，覆盖这个接口的抽象方法来调用给定的方法。在这个例子中，会生成一个ActionListener，它的actionPerformed(ActionEvent e)方法要调用System.out.println(e)。



我的理解是：

​	在new Timer(1000, event -> System.out.println(event));这方法中，第二个参数本来是要接收一个实现了ActionListener接口的对象，这个对象重写了接口的actionPerformed(ActionEvent e)方法。由于这个接口是函数式接口，所以可以用lambda表达式代替。

​	然后，由于这个重写的方法里面，只调用一个方法而不做其他操作，所以可以把lambda表达式重写为方法引用。var timer = new Timer(100, System.out::println);



方法引用要使用：：运算符分隔对象或类名与方法名。主要有3种情况：

1. object::instanceMethod
2. Class::instanceMethod
3. Class::staticMethod

在第1种情况下，方法引用等价于向方法传递参数的lambda表达式。对于System.out::println，对象是System.out，所以方法表达式等价于x -> System.out.println(x)；

对于第2种情况，第1个参数会成为方法的隐式参数，例如，String::compareToIgnoreCase等价于(x, y) -> x.compareToIgnoreCase(y);

在第3种情况下，所有参数都传递到静态方法，Math::pow等价于(x, y) -> Math.pow(x, y);





六、构造器引用



七、变量作用域