package com.dhieugo.ecommerce.product.dto.request;

import com.dhieugo.ecommerce.product.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilterRequest {

    private List<Long> categories;
    private List<Long> brands;
    private List<String> colors;
    private String price;

    public ProductFilterRequest(List<Long> categories, List<Long> brands, List<String> colors, String price) {
        this.categories = categories;
        this.brands = brands;
        this.colors = colors;
        this.price = price;
    }

    public Specification<Product> buildQuery() {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (categories != null && categories.size() > 0) {
                predicates.add(root.get("category").in(categories));
            }

            if (brands != null && brands.size() > 0) {
                predicates.add(root.get("brand").in(brands));
            }

            if (colors != null && colors.size() > 0) {
                Join<Object, Object> join = root.join("attributes");
                Path value = join.get("attributeValue");
                predicates.add(cb.lower(value).in(colors.stream().map(c -> c.toLowerCase()).collect(Collectors.toList())));
            }

            if (StringUtils.hasText(price)) {
                String[] prices = StringUtils.tokenizeToStringArray(price, ",-");
                predicates.add(cb.between(root.get("price"), Long.valueOf(prices[0]), Long.valueOf(prices[1])));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    @Override
    public String toString() {
        return "ProductFilterRequest{" +
                "categories=" + categories +
                ", brands=" + brands +
                ", colors=" + colors +
                ", price='" + price + '\'' +
                '}';
    }
}
