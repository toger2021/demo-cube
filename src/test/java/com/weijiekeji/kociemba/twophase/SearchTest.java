package com.weijiekeji.kociemba.twophase;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SearchTest {

    @RepeatedTest(100)
    //@Test
    public void searchSolutionThreadSafe() {
        System.out.println(Thread.currentThread().getName()+ "Start CoordCube");
        Long starttime = System.currentTimeMillis();
		new CoordCube();
		System.out.println("=>"+(System.currentTimeMillis()-starttime));

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