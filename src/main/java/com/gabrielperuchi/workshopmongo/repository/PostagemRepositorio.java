package com.gabrielperuchi.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gabrielperuchi.workshopmongo.domain.Postagem;

@Repository
public interface PostagemRepositorio extends MongoRepository<Postagem, String> {

	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Postagem> buscaPorTitulo(String texto);
	
	List<Postagem> findByTituloContainingIgnoreCase(String texto);
	
	@Query("{ $and: [ {data: {$gte: ?1} }, { data: { $lte: ?2} }, { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Postagem> buscaPersonaliada(String texto, Date dataMin, Date dataMax);
	
}
