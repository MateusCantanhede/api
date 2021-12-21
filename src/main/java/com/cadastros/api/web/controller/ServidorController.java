package com.cadastros.api.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadastros.api.entity.Lotacao;
import com.cadastros.api.entity.Servidor;
import com.cadastros.api.service.LotacaoService;
import com.cadastros.api.service.ServidorService;

@Controller
@RequestMapping("/servidor")
public class ServidorController {
	
	@Autowired
	private ServidorService servidorService;
	
	@Autowired
	private LotacaoService lotacaoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Servidor servidor) {
		return "/servidor/cadastrar";
	}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("servidores",servidorService.buscarTodos());
		return "/servidor/listar";
	}
	
	@PostMapping("/salvar")
	public String salvar(Servidor servidor, RedirectAttributes attr){
		try {
			servidorService.salvar(servidor);
			attr.addFlashAttribute("success","Servidor cadastrado com sucesso");
		} catch (Exception e) {
			attr.addFlashAttribute("fail","Servidor não pode ser cadastrado");
		}
		
		
		return "redirect:/servidor/cadastrar";
	}
	@ModelAttribute("lotacoes")
	public List<Lotacao> listaLotacoes(){
		return lotacaoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id,ModelMap model) {
		model.addAttribute("servidor", servidorService.buscarPorId(id));
		return"/servidor/cadastrar";
	}
	
	@PostMapping("/editar")
	public String editar(Servidor servidor,RedirectAttributes attr) {
		try {
			servidorService.editar(servidor);
			attr.addFlashAttribute("success","Servidor editado com sucesso.");
		} catch (Exception e) {
			attr.addFlashAttribute("fail","Servidor não pode ser editado");
		}
		
		return"redirect:/servidor/editar/"+servidor.getId();
	}
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id,ModelMap model) {
		try {
			if(servidorService.ServiceTemLotacao(id)) {
				Servidor serv = servidorService.buscarPorId(id);
				serv.setLotacao(null);
				servidorService.excluir(id);
				model.addAttribute("success","Servidor removido com sucesso.");
			}
		}
		catch (Exception e){
			model.addAttribute("fail","Servidor não removido.");
		}
		return listar(model);
	}
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome,ModelMap model) {
		model.addAttribute("servidores", servidorService.buscarPorNome(nome));
		return "/servidor/listar";
	}
	@GetMapping("/buscar/matricula")
	public String getPorMatricula(@RequestParam("matricula") String matricula,ModelMap model) {
		model.addAttribute("servidores", servidorService.buscarPorMatricula(matricula));
		return "/servidor/listar";
	}
	@GetMapping("/buscar/data")
	public String getPorData(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate data,ModelMap model) {
		model.addAttribute("servidores", servidorService.buscarPorData(data));
		return "/servidor/listar";
	}
}

