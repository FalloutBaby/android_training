package com.bbocelot.studentlist;

import com.anupcowkur.herebedragons.SideEffect;

public class Student {

    public final String name;
    public final String surname;
    public final boolean sex;
    public final Integer avatar;

    public Student(String name, String surname, boolean sex, Integer avatar) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        if (avatar == null) {
            this.avatar = (sex == true) ? R.drawable.silver_the_cat : R.drawable.siesta_the_cat;
        } else {
            this.avatar = avatar;
        }
    }
}
