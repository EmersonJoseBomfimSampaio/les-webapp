package com.bestgroup.util.assembler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.servlet.ServletRequest;

import com.bestgroup.core.domain.Entity;

@FunctionalInterface
public interface EntityAssembler <T extends Entity>{
	
	public static <U extends Entity> EntityAssembler<U> of(U entity) { 
		return request -> entity;
	}
	
	public static <U extends Entity> EntityAssembler<U> of(Supplier<U> supplier) { 
		return request -> supplier.get();
	}
	
	public default EntityAssembler<T> stringParam(String name, BiConsumer<T, String> setter) { 
		return param(name, setter, value -> value.trim().length() == 0 ? null : value.trim());
	}
	
	public default EntityAssembler<T> booleanParam(String name, BiConsumer<T, Boolean> setter) { 
		return param(name, setter, Boolean::valueOf);
	}
	
	public default EntityAssembler<T> integerParam(String name, BiConsumer<T, Integer> setter) {
		return param(name, setter, Integer::valueOf);
	}
	
	public default EntityAssembler<T> doubleParam(String name, BiConsumer<T, Double> setter) {
		return param(name, setter, Double::valueOf);
	}
	
	public default EntityAssembler<T> timestampParam(String name, BiConsumer<T, Date> setter) {
		return dateParam(name, setter, "yyyy-MM-dd hh:mm:ss.SSS");
	}
	
	public default EntityAssembler<T> dateParam(String name,  BiConsumer<T, Date> setter, String format) {
		return param(name, setter, value -> {
			SimpleDateFormat formater = new SimpleDateFormat(format);
			Date date = null;
			try {
				date = formater.parse(value);
			} catch (ParseException e) {
				//Does nothing
				e.printStackTrace();
			}
			return date;
		});  
	}
	
	public default <U> EntityAssembler<T> param(String name, BiConsumer<T, U> setter, Function<String, U> converter) { 
		return request -> {
			T entity = get(request);
			try {
				setter.accept(entity, converter.apply(request.getParameter(name).trim()));
			} catch (Exception e) { 
				//Does nothing
			} 
			return entity;
		};
	}
	
	public default <U extends Entity> EntityAssembler<T> entity(BiConsumer<T, U> setter , EntityAssembler<U> subAssembler) { 
		return request -> {
			T entity = get(request);
			setter.accept(entity, subAssembler.get(request));
			return entity;
		};
	}
	
	public default <U extends Entity> EntityAssembler<T> entity(BiConsumer<T, U> setter, BiConsumer<U, T> otherSetter, EntityAssembler<U> subAssembler) { 
		return request -> {
			T entity = get(request);
			U otherEntity =  subAssembler.get(request);
			setter.accept(entity, otherEntity);
			otherSetter.accept(otherEntity, entity);
			return entity;
		};
	}
	
	@SuppressWarnings("unchecked")
	public default <U> EntityAssembler<T> attribute(String name, BiConsumer<T, U> setter ) { 
		return request-> {
			T entity = get(request);
			setter.accept(entity, (U) request.getAttribute(name));
			return entity;
		};
	}
	
	public T get(ServletRequest request);
}
