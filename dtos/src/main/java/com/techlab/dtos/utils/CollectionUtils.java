package com.techlab.dtos.utils;

import com.techlab.dtos.models.domain.Product;
import java.util.HashMap;
import java.util.List;

public class CollectionUtils {

  public static HashMap<Long, Product> listToMap(List<Product> products) {
    HashMap<Long, Product> map = new HashMap<>();
    for (Product product : products) {
      map.put(product.getId(), product);
    }
    return map;
  }

}
