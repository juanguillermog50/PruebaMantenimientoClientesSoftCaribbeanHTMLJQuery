package softcaribbean.com.converter;

import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements AttributeConverter<Date, java.sql.Date> {

	@Override
	public java.sql.Date convertToDatabaseColumn(Date entityValue) {
		return new java.sql.Date(entityValue.getTime());
	}

	@Override
	public Date convertToEntityAttribute(java.sql.Date databaseValue) {
		return new Date(databaseValue.getTime());
	}
	

}
