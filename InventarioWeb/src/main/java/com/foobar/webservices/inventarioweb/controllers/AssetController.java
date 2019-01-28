package com.foobar.webservices.inventarioweb.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

import com.foobar.webservices.inventarioweb.entities.Asset;
import com.foobar.webservices.inventarioweb.repositories.AssetsRepository;

@RestController
@RequestMapping("/assets")
public class AssetController {
	public static final String FORMATO_FECHA = "yyyyMMdd";
	@Autowired
	AssetsRepository assetRepo;
	
	@GetMapping(path="/{fecha}")
	public ResponseEntity<?> getDocument(@PathVariable("fecha") String fecha){
		DateFormat df = new SimpleDateFormat(FORMATO_FECHA);
		Asset document= null;
		
		try {
			 document= assetRepo.getAssetByFecha(df.parse(fecha));
		} catch(ParseException ex) {
			return new ResponseEntity("Formato incorrecto de fecha", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NoResultException ex2) {
			return new ResponseEntity("Documento no encontrado", HttpStatus.NOT_FOUND);
		}
		Path ruta= Paths.get(document.getRuta());
		byte[] fileContents;
		try {
			fileContents= Files.readAllBytes(ruta);
		} catch (IOException e) {
			return new ResponseEntity("No se pudo cargar el documento", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String encoded= Base64.getEncoder().encodeToString(fileContents);
//		System.out.println("contenido: " + encoded);
//		String encoded = "";
//		encoded = new String(fileContents);
		
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Disposition", String.format("inline; filename=\"" + document.getNombre()));
		
//		ResponseEntity<?> respuesta = ResponseEntity.ok().headers(headers)
//				.contentLength(fileContents.length).contentType(MediaType.APPLICATION_PDF).body(encoded);
		
		ResponseEntity<?> respuesta = ResponseEntity.ok(encoded);
		return respuesta;
	}
}
