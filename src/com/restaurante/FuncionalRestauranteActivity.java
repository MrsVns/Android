package com.restaurante;

import com.restaurante.dao.RestauranteDao;
import com.restaurante.entidade.Restaurante;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FuncionalRestauranteActivity extends Activity {

	private Spinner categoria;
	private EditText nome;
	private EditText telefone;
	private EditText endereco;
	private AutoCompleteTextView cidade;
	private Spinner uf;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrorestaurante);
		
		String[] dadosCategoria = {"Italiana", "Brasileira",
				"Tailandesa", "Japonesa", "Russa"};
		ArrayAdapter<String> adapterCategoria = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dadosCategoria);
		Spinner categoria = (Spinner) findViewById(R.id.categoria);
		categoria.setAdapter(adapterCategoria);
		
		String[] dados = {"Itobi", "Casa Branca", "Vargem", 
				"São João da Boa Vista", "Santa Cruz das Palmeiras",
				"São Sebastião da grama", "São José", "Santos"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dados);
		AutoCompleteTextView cidade = (AutoCompleteTextView) findViewById(R.id.cidade);
		cidade.setAdapter(adapter);
		
		String[] dadosUf = {"AC", "AL", "AP", "AM", "BA", "CE",
				"DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR",
				"PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO",
				"RR", "SC", "SE", "SP", "TO","SR", "PC"};
		ArrayAdapter<String> adapterUF = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dadosUf);
		Spinner uf = (Spinner) findViewById(R.id.uf);
		uf.setAdapter(adapterUF);
		
		this.categoria = (Spinner) findViewById(R.id.categoria);
		
		this.nome = (EditText) findViewById(R.id.nome);
		
		this.telefone = (EditText) findViewById(R.id.telefone);
		
		this.endereco = (EditText) findViewById(R.id.endereco);
		
		this.cidade = (AutoCompleteTextView) findViewById(R.id.cidade);
		
		this.uf = (Spinner) findViewById(R.id.uf);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurante, menu);
		return true;
	}
	
	public void cadastroClick(View view){

	Restaurante res = new Restaurante();
	res.setCategoria(categoria.getSelectedItem().toString());
	res.setNome(nome.getText().toString());
	res.setTelefone(telefone.getText().toString());
	res.setEndereco(endereco.getText().toString());
	res.setCidade(cidade.getText().toString());
	res.setUf(uf.getSelectedItem().toString());
	
	RestauranteDao.criarInstancia().cadastrar(res);
	
	
	Intent intent = new Intent(this, MainActivity.class);
	startActivity(intent);
		
	}
	

}

