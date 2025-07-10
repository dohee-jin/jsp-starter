package com.jsp.basic.chap02;

import java.util.ArrayList;
import java.util.List;

// 댄서들을 모아서 관리하는 클래스
public class DancerRepository {

    private static List<Dancer> dancerList;

    static {
        dancerList = new ArrayList<>(
                List.of(
                        new Dancer("춘식이", "카카오프렌즈", DanceLevel.AMATEUR, List.of(Genre.HIPHOP, Genre.KPOP)),
                        new Dancer("폼폼푸린", "산리오친구들", DanceLevel.BEGINNER, List.of(Genre.STREET, Genre.KPOP)),
                        new Dancer("어피치", "카카오프렌즈", DanceLevel.PROFESSIONAL, List.of(Genre.KPOP))
                )
        );
    }

    // 댄서 목록을 갖다주는 기능
    public static List<Dancer> getDancerList() {
        return dancerList;
    }
    // 댄서 목록에 댄서를 추가하는 기능
    public static void addDancer(Dancer dancer) {
        dancerList.add(dancer);
    }
    // 댄서 목록에서 댄서를 제거하는 기능
    public static void removeDancer(int index) {
        dancerList.remove(index);
    }

}
