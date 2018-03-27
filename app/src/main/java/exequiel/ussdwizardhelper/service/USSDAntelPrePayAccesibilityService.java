package exequiel.ussdwizardhelper.service;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import javax.inject.Inject;

import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.root.App;

/**
 * Created by egonzalez on 13/03/18.
 */

public class USSDAntelPrePayAccesibilityService extends AccessibilityService {

    private static final String TAG = USSDAntelPrePayAccesibilityService.class.getCanonicalName();


    @Override
    public void onCreate() {
        ((App) getApplication()).getComponent().inject(this);
        super.onCreate();
    }
    @Inject
    LocalStorage localStorage;
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.d(TAG, "onAccessibilityEvent");
        AccessibilityNodeInfo rootNode = accessibilityEvent.getSource();
        if (rootNode == null) return;
        try {
            AccessibilityNodeInfo firstChild = rootNode.getChild(0);
            if (firstChild!=null && firstChild.getText().toString().contains("Servicios de Antel USSD")){
                Log.d(TAG,"Elejir prepago");
                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "3");
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                        childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            }else if (firstChild!=null && firstChild.getText().toString().contains("Bienvenido al sistema de registro de celulares prepagos.")){
                Log.d(TAG,"elejir dni");

                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "1");
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            } else

            if (firstChild!=null && firstChild.getText().toString().contains("Por favor, ingrese su cedula de identidad sin puntos ni guiones:")){
                Log.d(TAG,"poner cdi");

                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, localStorage.readValue("uid"));
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            } else

            if (firstChild!=null && firstChild.getText().toString().contains("Ingrese su año de su nacimiento (Ej 1989):")){
                Log.d(TAG,"poner anio");

                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, localStorage.readValue("udate").split("-")[0]);
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            } else

            if (firstChild!=null && firstChild.getText().toString().contains("Ingrese el mes de su nacimiento (Ej 01):")){

                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, localStorage.readValue("udate").split("-")[1]);
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            } else

            if (firstChild!=null && firstChild.getText().toString().contains("Ingrese el dia de su nacimiento (Ej 01):")){

                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, localStorage.readValue("udate").split("-")[2]);
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            }

            if (firstChild!=null && firstChild.getText().toString().contains("Su servicio quedara registrado a nombre de")){


                AccessibilityNodeInfo editTextChild = rootNode.getChild(1);
                Bundle bundle = new Bundle();
                bundle.putCharSequence(AccessibilityNodeInfo
                        .ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "1");
                editTextChild.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, bundle);
                AccessibilityNodeInfo childSend = rootNode.getChild(2).getChild(1);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            }

            if (firstChild!=null && firstChild.getText().toString().contains("Tu registro fue exitoso.")){

                AccessibilityNodeInfo childSend = rootNode.getChild(1).getChild(0);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                localStorage.writeString("state", "succes");

            }

            if (firstChild!=null && firstChild.getText().toString().contains("Ya se encuentra registrado en el sistema.")){

                AccessibilityNodeInfo childSend = rootNode.getChild(1).getChild(0);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                localStorage.writeString("state", "registered");

            }

            if (firstChild!=null && firstChild.getText().toString().contains("Los datos proporcionados son erroneos,")){

                AccessibilityNodeInfo childSend = rootNode.getChild(1).getChild(0);
                childSend.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                localStorage.writeString("state", "error");

            }

        }catch (NullPointerException e)
        {

        }catch (ArrayIndexOutOfBoundsException e){

        }

    }

    @Override
    public void onInterrupt() {

    }
}
