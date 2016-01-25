package com.yalantis.flip.sample;

import com.yalantis.flip.sample.model.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yalantis
 */
public class Utils {
    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.ivan, "Иван Царевич\nи Серый Волк 3", R.color.sienna, "Зал№1\nНачало сеанса: 10:00\nЦена билета: 100 рублей", "Зал№2\nНачало сеанса: 08:40\nЦена билета: 100 рублей"));
        friends.add(new Friend(R.drawable.vaves, "5 волна", R.color.saffron, "Зал№1\nНачало сеанса: 13:40\nЦена билета: 350 рублей", "Зал№2\nНачало сеанса 22:00\nЦена билета: 350 рублей"));
        friends.add(new Friend(R.drawable.chipmunk, "Элвин и бурундуки", R.color.green, "Зал№1\nНачало сеанса: 11:40\nЦена билета: 150 рублей", "Зал№2\nНачало сеанса: 08:40\nЦена билета: 100 рублей"));
        friends.add(new Friend(R.drawable.free, "Статус: Свободен", R.color.pink, "Зал№1\nНачало сеанса: 18:00\nЦена билета: 300 рублей", "Зал№2\nНачало сеанса: 10:20\nЦена билета: 300 рублей"));
        friends.add(new Friend(R.drawable.grandpa, "Дедушка легкого поведения", R.color.orange, "Зал№1\nНачало сеанса: 22:10\nЦена билета: 250 рублей", "Зал№2\nНачало сеанса: 14:40\nЦена билета: 250 рублей"));
        friends.add(new Friend(R.drawable.life, "Выживший", R.color.saffron, "Зал№1\nК сожалению, в зале №1\nфильм не показывают", "Зал№2\nНачало сеанса: 16:50\nЦена билета: 250 рублей"));
    }
}
