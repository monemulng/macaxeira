package com.macaxeira.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final String BANCO_DADOS = "MacaxeiraDB";
	private static int VERSAO = 1;

	public DatabaseHelper(Context context) {
		super(context, BANCO_DADOS, null, VERSAO);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("TESTE DE BANCO", "Entrou");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Categoria` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` ("
				+ "`_id` INT NOT NULL AUTO_INCREMENT,"
				+ "`nome` TEXT NOT NULL,"
				+ "`del` TINYINT(1) NULL DEFAULT 0"
				+ " `dataUpdate` TIMESTAMP NULL,"
				+ "PRIMARY KEY (`_id`));");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Produto` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Produto` ("
				+ "`_id` INT NOT NULL AUTO_INCREMENT"
				+ " `nome` TEXT NOT NULL"
				+ " `preco` DOUBLE NOT NULL,"
				+ "`categoria_id` INT NOT NULL,"
				+ " `del` TINYINT(1) NULL DEFAULT 0,"
				+ " `dataUpdate` TIMESTAMP NULL,"
				+ "PRIMARY KEY (`_id`),"
				+ "INDEX `fk_Produto_Categoria_idx` (`categoria_id` ASC)"
				+ " CONSTRAINT `fk_Produto_Categoria`"
				+ " FOREIGN KEY (`categoria_id`)"
				+ " REFERENCES `mydb`.`Categoria` (`_id`)"
				+ " ON DELETE NO ACTION"
				+ " ON UPDATE NO ACTION);");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Ingrediente` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Ingrediente` ("
				+ "`_id` INT NOT NULL AUTO_INCREMENT,"
				+ "`nome` TEXT NOT NULL,"
				+ "`del` TINYINT(1) NULL DEFAULT 0,"
				+ "`dataUpdate` TIMESTAMP NULL,"
				+ "PRIMARY KEY (`_id`));");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Produto_has_Ingrediente` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Produto_has_Ingrediente` ("
				+ "`Produto_id` INT NOT NULL,"
				+ " `Ingrediente_id` INT NOT NULL,"
				+ " PRIMARY KEY (`Produto_id`, `Ingrediente_id`),"
				+ " INDEX `fk_Produto_has_Ingrediente_Ingrediente1_idx` (`Ingrediente_id` ASC),"
				+ " INDEX `fk_Produto_has_Ingrediente_Produto1_idx` (`Produto_id` ASC),"
				+ " CONSTRAINT `fk_Produto_has_Ingrediente_Produto1`"
				+ "FOREIGN KEY (`Produto_id`)"
				+ " REFERENCES `mydb`.`Produto` (`_id`)"
				+ " ON DELETE NO ACTION"
				+ " ON UPDATE NO ACTION,"
				+ " CONSTRAINT `fk_Produto_has_Ingrediente_Ingrediente1`"
				+ " FOREIGN KEY (`Ingrediente_id`)"
				+ " REFERENCES `mydb`.`Ingrediente` (`_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION);");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Adicional` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Adicional` ("
				+ " `_id` INT NOT NULL AUTO_INCREMENT,"
				+ " `nome` TEXT NOT NULL,"
				+ " `preco` DOUBLE NOT NULL,"
				+ " `del` TINYINT(1) NULL DEFAULT 0,"
				+ " `dataUpdate` TIMESTAMP NULL,"
				+ " PRIMARY KEY (`_id`));");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Produto_has_Adicional` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Produto_has_Adicional` ("
				+ "`Produto_id` INT NOT NULL,"
				+ "`Adicional_id` INT NOT NULL,"
				+ "PRIMARY KEY (`Produto_id`, `Adicional_id`),"
				+ "INDEX `fk_Produto_has_Adicional_Adicional1_idx` (`Adicional_id` ASC),"
				+ "INDEX `fk_Produto_has_Adicional_Produto1_idx` (`Produto_id` ASC),"
				+ "CONSTRAINT `fk_Produto_has_Adicional_Produto1`"
				+ "FOREIGN KEY (`Produto_id`)"
				+ "REFERENCES `mydb`.`Produto` (`_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION,"
				+ " CONSTRAINT `fk_Produto_has_Adicional_Adicional1`"
				+ " FOREIGN KEY (`Adicional_id`)"
				+ "REFERENCES `mydb`.`Adicional` (`_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION);");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Pedido` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Pedido` ("
				+ "`_id` INT NOT NULL AUTO_INCREMENT,"
				+ "`preco` DOUBLE NOT NULL,"
				+ "PRIMARY KEY (`_id`));");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Item_Pedido` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Item_Pedido` ("
				+ "`Item_Pedido_id` INT NOT NULL,"
				+ "`Pedido_id` INT NOT NULL,"
				+ "`Produto_id` INT NOT NULL,"
				+ "`Preco` DOUBLE NULL,"
				+ "PRIMARY KEY (`Item_Pedido_id`, `Pedido_id`, `Produto_id`),"
				+ "INDEX `fk_Pedido_has_Produto_Produto1_idx` (`Produto_id` ASC),"
				+ "INDEX `fk_Pedido_has_Produto_Pedido1_idx` (`Pedido_id` ASC),"
				+ "CONSTRAINT `fk_Pedido_has_Produto_Pedido1`"
				+ "FOREIGN KEY (`Pedido_id`)"
				+ "REFERENCES `mydb`.`Pedido` (`_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION,"
				+ "CONSTRAINT `fk_Pedido_has_Produto_Produto1`"
				+ "FOREIGN KEY (`Produto_id`)"
				+ "REFERENCES `mydb`.`Produto` (`_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION);");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Ingrediente_Excluido` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Ingrediente_Excluido` ("
				+ "`Item_Pedido_id` INT NOT NULL,"
				+ "`Ingrediente_id` INT NOT NULL,"
				+ "PRIMARY KEY (`Item_Pedido_id`, `Ingrediente_id`),"
				+ "INDEX `fk_Item_Pedido_has_Ingrediente_Ingrediente1_idx` (`Ingrediente_id` ASC),"
				+ "INDEX `fk_Item_Pedido_has_Ingrediente_Item_Pedido1_idx` (`Item_Pedido_id` ASC),"
				+ "CONSTRAINT `fk_Item_Pedido_has_Ingrediente_Item_Pedido1`"
				+ "FOREIGN KEY (`Item_Pedido_id`)"
				+ "REFERENCES `mydb`.`Item_Pedido` (`Item_Pedido_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION,"
				+ "CONSTRAINT `fk_Item_Pedido_has_Ingrediente_Ingrediente1`"
				+ "FOREIGN KEY (`Ingrediente_id`)"
				+ "REFERENCES `mydb`.`Ingrediente` (`_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION);");
		
		db.execSQL("DROP TABLE IF EXISTS `mydb`.`Item_Pedido_has_Adicional` ;"
				+ "CREATE TABLE IF NOT EXISTS `mydb`.`Item_Pedido_has_Adicional` ("
				+ "`Item_Pedido_id` INT NOT NULL,"
				+ "`Adicional_id` INT NOT NULL,"
				+ "PRIMARY KEY (`Item_Pedido_id`, `Adicional_id`),"
				+ "INDEX `fk_Item_Pedido_has_Adicional_Adicional1_idx` (`Adicional_id` ASC),"
				+ "INDEX `fk_Item_Pedido_has_Adicional_Item_Pedido1_idx` (`Item_Pedido_id` ASC),"
				+ "CONSTRAINT `fk_Item_Pedido_has_Adicional_Item_Pedido1`"
				+ "FOREIGN KEY (`Item_Pedido_id`)"
				+ "REFERENCES `mydb`.`Item_Pedido` (`Item_Pedido_id`)"
				+ "ON DELETE NO ACTION"
				+ "ON UPDATE NO ACTION,"
				+ "CONSTRAINT `fk_Item_Pedido_has_Adicional_Adicional1`"
				+ "FOREIGN KEY (`Adicional_id`)"
				+ "REFERENCES `mydb`.`Adicional` (`_id`)"
				+ "ON DELETE NO ACTION);");
		
		ContentValues values = new ContentValues();
		
		values.put("nome", "Sanduíches");
		db.insert("categoria", null, values);
		values.clear();
		values.put("nome", "Batatas");
		db.insert("categoria", null, values);
		values.clear();
		
		values.put("nome", "Hamburger");
		values.put("preco", 9.99);
		values.put("categoria_id", 1);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Frango");
		values.put("preco", 7.95);
		values.put("categoria_id", 1);
		db.insert("produto", null, values);         
		values.clear();
		values.put("nome", "Picanha");
		values.put("preco", 18.90);
		values.put("categoria_id", 1);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Batata P");
		values.put("preco", 3.75);
		values.put("categoria_id", 2);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Batata M");
		values.put("preco", 4.75);
		values.put("categoria_id", 2);
		db.insert("produto", null, values);
		values.clear();
		values.put("nome", "Batata G");
		values.put("preco", 6.50);
		values.put("categoria_id", 2);
		db.insert("produto", null, values);
		values.clear();
	
		values.put("nome", "Pao");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Hamburguer bovino");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Hamburguer de frango");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Alface");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Tomate");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Picles");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Ovo");
		db.insert("ingrediente", null, values);
		values.clear();
		values.put("nome", "Batata");
		db.insert("ingrediente", null, values);
		values.clear();		
		
		values.put("nome", "Bacon" );
		values.put("preco", 1.75);
		db.insert("adicional", null, values);
		values.clear();
		values.put("nome", "Chedar" );
		values.put("preco", 0.99);
		db.insert("adicional", null, values);
		values.clear();		
		values.put("nome", "Milho" );
		values.put("preco", 0.75);
		db.insert("adicional", null, values);
		values.clear();
		values.put("nome", "Catupiry" );
		values.put("preco", 2.00);
		db.insert("adicional", null, values);
		values.clear();		
		values.put("nome", "Molho barbecue" );
		values.put("preco", 1.50);
		db.insert("adicional", null, values);
		values.clear();
		values.put("nome", "Ervilha" );
		values.put("preco", 0.75);
		db.insert("adicional", null, values);
		values.clear();
		
		values.put("Produto_id", 1);
		values.put("Ingrediente_id", 1);
		db.insert("Produto_has_Ingrediente", null, values);
		values.put("Produto_id", 1);
		values.put("Ingrediente_id", 2);
		db.insert("Produto_has_Ingrediente", null, values);
		values.put("Produto_id", 1);
		values.put("Ingrediente_id", 4);
		db.insert("Produto_has_Ingrediente", null, values);
		values.put("Produto_id", 1);
		values.put("Ingrediente_id", 5);
		db.insert("Produto_has_Ingrediente", null, values);
		values.put("Produto_id", 1);
		values.put("Ingrediente_id", 6);
		db.insert("Produto_has_Ingrediente", null, values);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
