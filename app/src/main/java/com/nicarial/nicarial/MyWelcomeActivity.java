package com.nicarial.nicarial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

public class MyWelcomeActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorPrimaryDark)
                .page(new TitlePage(R.drawable.logo,
                        "Bienvenidos a NicaRial")
                )
                .page(new BasicPage(R.drawable.calculator,
                        "Registro de Calculos e Ingresos de tu Dia a Dia",
                        "Con esta aplicación sencilla podrás hacer un calculo rápido de tus ingresos.")
                        .background(R.color.colorPrimaryDark)
                )
                .page(new BasicPage(R.drawable.feedback,
                        "¿Sugerencias?",
                        "Esta app apenas esta en desarrollo, pero muy pronto habrá nuevas opciones. Envianos tus comentarios cuando quieras.")
                        .background(R.color.red_background)
                )
                .page(new BasicPage(R.drawable.donation,
                        "¿Estás listo?",
                        "¡Empieza a probar Nicarial!")
                        .background(R.color.colorPrimaryDark)
                )

                .swipeToDismiss(true)
                .build();
    }
}
