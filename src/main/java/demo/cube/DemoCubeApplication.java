package demo.cube;

import org.kociemba.twophase.CoordCube;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * emil:410758717@qq.com
 * Created by togger on 2021/4/8.
 */

@SpringBootApplication

public class DemoCubeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoCubeApplication.class,args);
        new CoordCube(); // 充实话魔方类静态变量
    }
}
