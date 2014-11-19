package com.restaurante;

import java.util.List;

import com.restaurante.dao.RestauranteDao;
import com.restaurante.entidade.Restaurante;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);

		final List<Restaurante> dados = RestauranteDao.listarRestaurantes();

		final ArrayAdapter<Restaurante> adapter = new ArrayAdapter<Restaurante>(
				this, android.R.layout.simple_list_item_1, dados);

		ListView lista = (ListView) findViewById(R.id.lista);

		lista.setAdapter(adapter);

		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int posi,
					long arg3) {
				Context context = getApplicationContext();
				Restaurante rest = null;
				
				
				for (Restaurante restaurante : dados) {
					rest = new Restaurante();
					rest.setTelefone(restaurante.getTelefone());	
				}
				
				Toast toast = Toast.makeText(context, rest.getTelefone() , Toast.LENGTH_SHORT);
				toast.show();
	
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void cadastrarAoClicar(View view) {
		Intent intent = new Intent(this, FuncionalRestauranteActivity.class);
		startActivity(intent);
	}

}
