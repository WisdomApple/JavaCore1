[TOC]

<div STYLE="page-break-after: always;"></div>

# 第2章 Java程序设计环境

| $\blacktriangle$ [安装Java开发工具包](#2.1 安装Java开发工具包) | $\blacktriangle$ [运行图形化应用程序](#2.4 运行图形化应用程序) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| $\blacktriangle$ [使用命令行工具](#2.2 使用命令行工具)       | $\blacktriangle$ [构建并运行applet](#2.5 构建并运行applet)   |
| $\blacktriangle$ [使用集成开发环境](#2.3 使用集成开发环境)   |                                                              |

本章主要介绍如何安装 Java 开发工具包（ JDK ) 以及如何编译和运行不同类型的程序：控制台程序、图形化应用程序以及 applet 。

## 2.1 安装Java开发工具包

&emsp;&emsp;Oracle 公司为 Linux 、 Mac OS X 、 Solaris 和 Windows 提供了 Java 开发工具包 (JDK) 的最新、最完整的版本。用于很多其他平台的版本仍处于多种不同的开发状态中，不过，这些版本都由相应平台的开发商授权并分发。 

### 2.1.1 下载JDK

&emsp;&emsp;要想下载 Java 开发工具包，可以访问 Oracle 网站：[java下载](https://www.oracle.com/java/technologies/javase-downloads.html)，在得到所需的软件之前必须弄清楚大量专业术语。

<center>java 术语表</center>

|          术语名          | 缩写 |                             解释                             |
| :----------------------: | :--: | :----------------------------------------------------------: |
|   Java Development Kit   | JDK  |               编M Java 程序的程序员使用的软件                |
| Java Runtime Environment | JRE  |               JREJava Runtime Environment JRE                |
|        Server JRE        |  ——  |                在服务器上运行 Java 程序的软件                |
|     Standard Edition     |  SE  |             用于桌面或简单服务器应用的 Java 平台             |
|    Enterprise Edition    |  EE  |                用于复杂服务器应用的 Java 平台                |
|      Micro Edition       |  ME  |              用于手机和其他小型设备的 Java 平台              |
|         Java FX          |  ——  | 用于图形化用户界面的一个替代工具包， <br />在 Oracle 的 Java SE 发布版本中提供 |
|         OpenJDK          |  ——  |    JavaSE 的 一个免费幵源实现， 不包含浏览器集成或 JavaFX    |
|          Java 2          |  J2  |  一个过时的术语，用于描述1998 年 〜 2006 年之间的 Java 版本  |
| Software Development Kit | SDK  |     一个过时的术语，用于描述1998 年 〜 2006 年之间的 JDK     |
|          Update          |  u   |              Oracle 的术语， 表示 bug 修正版本               |
|         NetBeans         |  ——  |                    Oracle 的集成开发环境                     |

### 2.1.2 设置JDK

### 2.1.3 安装库源文件和文档

&emsp;&emsp;库源文件在 JDK 中以一个压缩文件 src.zip 的形式发布， 必须将其解压缩后才能够访问源代码。 建议按照下面所述的步骤进行操作。很简单：

 1. 确保 JDK 已经安装， 并且 jdk/bin 目录在执行路径中。  

 2. 在主目录中建立一个目录 javasrc。 如果愿意，可以在一个终端窗口完成这个步骤。`mkdir javasrc`

 3. 在 jdk 目录下找到文件 src.zip。  

 4. 将 src.zip 文件解压缩到 javasrc 目录。在一个终端窗口中，可以执行以下命令：
    `cd javasrc`      `jar xvf yrffc/src.zip`  `cd ..`

:exclamation:提示：src.zip 文件中包含了所有公共类库的源代码。要想获得更多的源代码(例如： 编译器、虚拟机、本地方法以及私有辅助类)，请访问网站：http://jdk8.java.net。  

&emsp;&emsp;文档包含在一个压缩文件中，它是一个独立于JDK 的压缩文件。可以直接从网站 http://www.oracle.com/technetwork/java/javase/downloads 下载这个文档。操作步骤如下：

1 ) 下载文档压缩文件。这个文件名为 jdk-ver5/cw-docs-all.zip, 其中的表示版本号， 例如 8u31。

2 ) 解压缩这个文件，将 doc 目录重命名为一个更有描述性的名字，如 javadoc。如果愿意， 可以从命令行完 成这个工作：
`jar xvf Downloads/jdk-wrswn-docs-all.zip`
`mv doc javadoc`
&emsp;&emsp;这里 version 是相应的版本号。
3 ) 在浏览器中导航到 javadoc/api/index.html, 将这个页面增加到书签。还要安装本书的程序示例。 可以从 http://horstmann.com/corejava 下载示例。这些程序打包在一个 zip 文件 corejava.zip 中。可以将程序解压缩到你的主目录。 它们会放在目录 corejava 中。 如果愿意，可以从命令行完成这个工作：
`jar xvf Downloads/corejava.zip`  

## 2.2 使用命令行工具

1) 打开一个终端窗口。
2) 进入 java 文件 Welcome 目录。
3) 键入下面的命令：
    `javac Welcome.java`
    `java Welcome`

&emsp;&emsp;javac 程序是一个 Java 编译器。 它将文件 Welcome.java 编译成 Welcome.class。java 程序启动 Java 虚拟机。 虚拟机执行编译器放在 class 文件中的字节码。
==程序清单 2-1 Welcome/Welcome.java==  

```java
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * A program for viewing images.
 *
 * @author Cay Horstmann
 * @version 1.30 2014-02-27
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a label to show an image.
 */

class ImageViewerFrame extends JFrame {
    private final JLabel label;
    private final JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // use a label to display the images
        label = new JLabel();
        add(label);

        // set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            // show file chooser dialog
            int result = chooser.showOpenDialog(null);

            // if file selected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}
```

## 2.3 使用集成开发环境

下面是用 Eclipse 编写程序的一般步骤。

1. After starting Eclipse, select File $\rarr$ New $\rarr$ Project from the menu. 
2. Select “Java Project” from the wizard dialog.
3. Click the Next button. Uncheck the “Use default location” checkbox. Click on Browse and navigate to the Welcome directory.
4. Click the Finish button. The project is now created.
5. Click on the triangles in the left pane next to the project until you locate the file Welcome.java, and double-click on it. You should now see a pane with the program code.
6. With the right mouse button, click on the project name (Welcome) in the left pane. Select Run $\rarr$ Run As $\rarr$ Java Application. The program output is displayed in the console pane.​

## 2.4 运行图形化应用程序

&emsp;&emsp;这是一个图形化应用程序。这个程序是一个简单的图像文件查看器 ( viewer)，它可以加载并显示一个图像。首先，由命令行编译并运行这个程序

    1. 打开一个终端窗口。 
       2. 进入 ImageViewer  
       3. 输入：
           `javac ImageViewer.java`
          `java ImageViwer`
          将弹出一个标题栏为 ImageViewer 的新程序窗口

==程序清单 2-2 ImageViewer/lmageViewer.java==

```java
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * A program for viewing images.
 *
 * @author Cay Horstmann
 * @version 1.30 2014-02-27
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame with a label to show an image.
 */

class ImageViewerFrame extends JFrame {
    private final JLabel label;
    private final JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // use a label to display the images
        label = new JLabel();
        add(label);

        // set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            // show file chooser dialog
            int result = chooser.showOpenDialog(null);

            // if file selected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}
```



## 2.5 构建并运行applet

首先，打开终端窗口并转到 RoadApplet，然后，输入下面的命令：

```shell
javac RoadApplet.java
jar cvfm RoadApplet.jar RoadApplet.mf *.dass
appletviewer RoadApplet.html
```

==程序清单 2-3 RoadApplet/RoadApplet.html==

```html
<html lang="" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>A Traffic Simulator Applet</title>
</head>
<body>
<h1>Traffic Simulator Applet</h1>

<p>
    I wrote this traffic simulation, following the article &quot;Und nun die
    Stauvorhersage&quot; of the German Magazine <i>Die Zeit</i>, June 7,
    1996. The article describes the work of Professor Michael Schreckenberger
    of the University of Duisburg and unnamed collaborators at the University
    of Cologne and Los Alamos National Laboratory. These researchers model
    traffic flow according to simple rules, such as the following:
</p>
<ul>
    <li>A freeway is modeled as a sequence of grid points.</li>
    <li>Every car occupies one grid point. Each grid point occupies at most
        one car.
    </li>
    <li>A car can have a speed of 0 - 5 grid points per time interval.</li>
    <li>A car with speed of less than 5 increases its speed by one unit in
        each time interval, until it reaches the maximum speed.
    </li>
    <li>If a car's distance to the car in front is <i>d</i> grid points, its
        speed is reduced to <i>d</i>-1 if necessary to avoid crashing into it.
    </li>
    <li>With a certain probability, in each time interval some cars slow down
        one unit for no good reason whatsoever.
    </li>
</ul>

<p>
    This applet models these rules. Each line shows an image of the same
    stretch of road. Each square denotes one car. The first scrollbar lets you
    adjust the probability that some cars slow down. If the slider is all the
    way to the left, no car slows down. If it is all the way to the right,
    every car slows down one unit. A typical setting is that 10% - 20% of the
    cars slow down. The second slider controls the arrival rate of the cars.
    When it is all the way to the left, no new cars enter the freeway. If it
    is all the way to the right, a new car enters the freeway every time
    interval, provided the freeway entrance is not blocked. </p>

<p>
    Try out the following experiments. Decrease the probability of slowdown
    to 0. Crank up the arrival rate to 1. That means, every time unit, a new
    car enters the road. Note how the road can carry this load.
</p>

<p>Now increase the probability that some cars slow down. Note how traffic
    jams occur almost immediately.
</p>

<p>
    The moral is: If it wasn't for the rubberneckers, the cellular phone
    users, and the makeup-appliers who can't keep up a constant speed, we'd all
    get to work more quickly.
</p>

<p>
    Notice how the traffic jam is stationary or even moves backwards, even
    though the individual cars are still moving. In fact, the first car
    causing the jam has long left the scene by the time the jam gets bad.
    (To make it easier to track cars, every tenth vehicle is colored red.)
</p>

<p>
    <applet alt="Traffic jam visualization" archive="RoadApplet/RoadApplet.jar"
            code="RoadApplet/RoadApplet.class" height="400" width="400">
    </applet>
</p>

<p>
    For more information about applets, graphics programming and
    multithreading in Java, see
    <a href="http://horstmann.com/corejava">Core Java</a>.
</p>
</body>
</html>
```

==程序清单 2-4 RoadApplet/RoadApplet.java== 

```java
public class RoadApplet extends JApplet {
    private RoadComponent roadComponent;
    private JSlider slowdown;
    private JSlider arrival;

    public void init() {
        EventQueue.invokeLater(() -> {
            roadComponent = new RoadComponent();
            slowdown = new JSlider(0, 100, 10);
            arrival = new JSlider(0, 100, 50);

            JPanel p = new JPanel();
            p.setLayout(new GridLayout(1, 6));
            p.add(new JLabel("Slowdown"));
            p.add(slowdown);
            p.add(new JLabel(""));
            p.add(new JLabel("Arrival"));
            p.add(arrival);
            p.add(new JLabel(""));
            setLayout(new BorderLayout());
            add(p, BorderLayout.NORTH);
            add(roadComponent, BorderLayout.CENTER);
        });
    }

    public void start() {
        new Thread(() ->
        {
            for (; ; ) {
                roadComponent.update(
                        0.01 * slowdown.getValue(),
                        0.01 * arrival.getValue());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {
                }
            }
        }).start();
    }
}
```

