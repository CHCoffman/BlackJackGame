package blackjack.controller;

import blackjack.model.Model;
import blackjack.view.View;

public interface Controller {
	void setModel(Model model);
	Model getModel();
	View getView();
	void setView(View view);
}