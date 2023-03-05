package org.team24.coursesmanager.random;

import org.team24.coursesmanager.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class RandomUser {
    public List<String> randomUser(List<User> userList){

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
                listUsers.add(newUserAfterRandom.get(i).getFirstname() + " " + newUserAfterRandom.get(i).getLastname() + "   < --- >   "
                        + newUserAfterRandom.get(0).getFirstname() + " " + newUserAfterRandom.get(0).getLastname());
            }
            else {
                listUsers.add(newUserAfterRandom.get(i).getFirstname() + " " + newUserAfterRandom.get(i).getLastname() + "   < --- >   "
                        + newUserAfterRandom.get(i + 1).getFirstname() + " " + newUserAfterRandom.get(i + 1).getLastname());
            }
        }
        return listUsers;
    }
}
