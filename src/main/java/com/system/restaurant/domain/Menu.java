package com.system.restaurant.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int menuId;
    private String menuName;
    private float menuPrice;
    private int cookingTime;
}
