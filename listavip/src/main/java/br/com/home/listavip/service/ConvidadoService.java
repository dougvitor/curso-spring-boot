package br.com.home.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.home.listavip.model.Convidado;
import br.com.home.listavip.repository.ConvidadoRepository;
import br.com.home.sendmail.service.EmailService;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repository;
	
	@Autowired
	private EmailService emailService;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Iterable<Convidado> obterTodos(){
		Iterable<Convidado> convidados = repository.findAll();
		return convidados;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
	public void salvar(Convidado convidado) {
		repository.save(convidado);
		emailService.enviar(convidado.getNome(), convidado.getEmail());
	}

}
