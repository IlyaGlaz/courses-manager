package org.team24.coursesmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class RandomUser {
    static List<String> randomUser(List<User> userList){

        if (userList == null) return null;

        List<User> newUserAfterRandom = new ArrayList<>();                          // создали список (newUserAfterRandom) User после рандома
        List<String> listUsers = new ArrayList<>();                                 // создали список из пар Users

        Random random = new Random();                                               // рандом

        while (userList.size() != newUserAfterRandom.size()){                       // пока списки не равны, будем искать User, которого еще не выбрали
            int tempNumber = random.nextInt(userList.size());
            if (newUserAfterRandom.contains(userList.get(tempNumber))) continue;    // если в списке (newUserAfterRandom) имеется выпавший User, то переходим к повторному рандому
            newUserAfterRandom.add(userList.get(tempNumber));
        }

        for (int i = 0; i < newUserAfterRandom.size(); i++){                        // пары Users
            if ((i + 1) == newUserAfterRandom.size()){
                listUsers.add(newUserAfterRandom.get(i).name + " " + newUserAfterRandom.get(i).surname + "< --- >"
                        + newUserAfterRandom.get(0).name + " " + newUserAfterRandom.get(0).surname);
            }
            else {
                listUsers.add(newUserAfterRandom.get(i).name + " " + newUserAfterRandom.get(i).surname + "< --- >"
                        + newUserAfterRandom.get(i + 1).name + " " + newUserAfterRandom.get(i + 1).surname);
            }
        }
        return listUsers;
    }
}
