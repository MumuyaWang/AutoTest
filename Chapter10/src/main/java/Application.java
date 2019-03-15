import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication                 //
@ComponentScan("com.course")    //需要扫描的包
//入口类
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);    //args就是个参数
    }
}
