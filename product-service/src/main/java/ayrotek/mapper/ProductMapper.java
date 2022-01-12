package ayrotek.mapper;

import ayrotek.dto.ProductDTO;
import ayrotek.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ProductMapper {

    Product toEntity (ProductDTO dto);

    ProductDTO toDto (Product entity);

    List<ProductDTO> toDto (List<Product> entityList);

    List<Product> toEntity (List<ProductDTO> entityList);

}
