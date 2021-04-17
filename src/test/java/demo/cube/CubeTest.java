package demo.cube;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kociemba.twophase.Cube;
import org.kociemba.twophase.Search;
import org.kociemba.twophase.SearchThreadSafe;
import org.kociemba.twophase.Tools;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class CubeTest {
    @RepeatedTest(100)
    public void searchSolutionThreadSafe() {
    System.out.println(Thread.currentThread().getName()+ "Start CoordCube");
        Long starttime = System.currentTimeMillis();
//		new CoordCube();
//		System.out.println("=>"+(System.currentTimeMillis()-starttime));


		for (int i=0;i<1;i++) {
            starttime = System.currentTimeMillis();
            String cubeStr = Tools.randomCube();
            System.out.println(Thread.currentThread().getName()+"cubeStr=>" +cubeStr);
            System.out.println(Thread.currentThread().getName()+" randomCube=>" + (System.currentTimeMillis() - starttime));

            starttime = System.currentTimeMillis();
            String moves = new SearchThreadSafe().solution(cubeStr ,22, 5, false); // solving it
            System.out.println(Thread.currentThread().getName()+" solution=>" + (System.currentTimeMillis() - starttime));

            System.out.println(Thread.currentThread().getName()+"solution[" + i + "]=>" +moves);

            Cube cube = new Cube(cubeStr);
            for(String move : moves.split(" ")) // rotating
                cube.rotate(move);

            assertTrue(cube.isSolved());

        }
    }

    @Test
    public void searchSolution() {
        System.out.println(Thread.currentThread().getName()+"Start CoordCube");
        Long starttime = System.currentTimeMillis();
//		new CoordCube();
//		System.out.println("=>"+(System.currentTimeMillis()-starttime));


        for (int i=0;i<5;i++) {
            starttime = System.currentTimeMillis();
            String cubeStr = Tools.randomCube();
            System.out.println(Thread.currentThread().getName()+"cubeStr=>" +cubeStr);
            System.out.println(Thread.currentThread().getName()+" randomCube=>" + (System.currentTimeMillis() - starttime));

            starttime = System.currentTimeMillis();
            String moves = Search.solution(cubeStr ,22, 5, false); // solving it
            System.out.println(Thread.currentThread().getName()+" solution=>" + (System.currentTimeMillis() - starttime));
            System.out.println(Thread.currentThread().getName()+"solution[" + i + "]=>" +moves);

            Cube cube = new Cube(cubeStr);
            for(String move : moves.split(" ")) // rotating
                cube.rotate(move);

            assertTrue(cube.isSolved());


        }
    }
}
