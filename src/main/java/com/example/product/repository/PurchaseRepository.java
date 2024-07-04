package com.example.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	
	@Query(value=" select c.name,p.product_name,pd.quantity,p.price,pd.total_amount from customer_detail as c "
			+ " inner join product_detail  as p on c.c_id= p.p_id "
			+ " inner join purchase_details as pd "
			+ " on p.p_id = pd.pill_id where name =:name",nativeQuery = true)
	Optional<ProductDto> findByName(String name);

}
