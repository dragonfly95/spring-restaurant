package com.system.restaurant.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int menu_id;
    private String menu_name;
    private float menu_price;
    private int cooking_time;
}
