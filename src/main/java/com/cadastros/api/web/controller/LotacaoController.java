package com.cadastros.api.web.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadastros.api.entity.Lotacao;
import com.cadastros.api.service.LotacaoService;

@Controller
@RequestMapping("/lotacao")
public class LotacaoController {
	@Autowired
	LotacaoService lotacaoService; 
	
	@GetMapping("/cadastrar")
	public String cadastrar(Lotacao lotacao) {
		return "/lotacao/cadastrar";
	}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("lotacoes",lotacaoService.buscarTodos());
		return "/lotacao/listar";
	}
	@PostMapping("/salvar")
	public String salvar(Lotacao lotacao, RedirectAttributes attr){
		
		try {
			lotacaoService.salvar(lotacao);
			attr.addFlashAttribute("success","Lotação cadastrada com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			attr.addFlashAttribute("fail","Lotação não cadastrada");

		}
		return "redirect:/lotacao/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id,ModelMap model) {
		model.addAttribute("lotacao", lotacaoService.buscarPorId(id));
		return"/lotacao/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(Lotacao lotacao,RedirectAttributes attr) {
		try {
			lotacaoService.editar(lotacao);
			attr.addFlashAttribute("success","Lotação editada com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			attr.addFlashAttribute("fail","Lotação não editada");

		}
		
		return"redirect:/lotacao/editar/"+lotacao.getId();
	}
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id,ModelMap model) {	
		try {
			lotacaoService.excluir(id);
			model.addAttribute("success","Servidor removido com sucesso.");
		} catch (Exception e) {
			model.addAttribute("fail","Servidor não foi removido. Possui servidores ativos");
		}	
		return listar(model);
	}
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome,ModelMap model) {
		model.addAttribute("lotacoes", lotacaoService.buscarPorNome(nome));
		return "/lotacao/listar";
	}
	@GetMapping("/buscar/descricao")
	public String getPorDescricao(@RequestParam("descricao") String descricao,ModelMap model) {
		model.addAttribute("lotacoes", lotacaoService.buscarPorDescricao(descricao));
		return "/lotacao/listar";
	}
	@GetMapping("/buscar/data")
	public String getPorData(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,ModelMap model) {
		model.addAttribute("lotacoes", lotacaoService.buscarPorData(data));
		return "/lotacao/listar";
	}
}
