## [app目录结构](https://www.jianshu.com/p/6f05a563690a)

1. **build**

        这个目录和外层的build目录类似，主要也是包含了一些在编译时自动生成的文件，不过它里面的内容会更多更杂，我们不需要过多关心。

2. **libs**

    存放**第三方jar包**，放在这个目录下的jar包都会被自动添加到构建路径里去。

3. **AndroidTest**

        此处是用来编写Android Test测试用例的，可以对项目进行一些自动化测试。

4. **java**

    存放**java文件**。主要工作目录。

5. **res**

    存放项目中使用到的所有**图片，布局，字符串等资源**。当然这个目录下还有很多子目录，图片放在drawable目录下，布局放在layout目录下，字符串放在values目录下，所以你不用担心会把整个res目录弄得乱糟糟的。

6. **AndroidManifest.xml**

    Android项目的配置文件，程序中定义的所有组件都需要在这个文件里注册；另外还可以在这个文件中给应用程序添加权限声明。

7. **test**

        此处是用来编写Unit Test测试用例的，是对项目进行自动化测试的另一种方式。

8. **.gitignore**

        用于将app模块内的指定的目录或文件排除在版本控制之外，作用和外层的.gitignore文件类似。

9. **app.iml**

        项目自动生成的文件，不需要关心或修改这个文件中的内容。

10. **build.gradle**

        这是app模块的gradle构建脚本，这个文件中会指定很多项目构建相关的配置。

11. **proguard-rules.pro**

        指定项目代码的混淆规则，当代码开发完成后打成安装包文件，如果不希望代码被别人破解，通常会将代码混淆，从而让破解者难以阅读。