package exequiel.ussdwizardhelper;

/**
 * Created by egonzalez on 08/03/18.
 */

public enum State {
        UNKNOWN_ERROR,
        NEED_CRM,
        NEED_ACCESIBILITY_SERVICE,
        NEED_CALL_SERVICE,
        NEED_SIM_ENABLED,
        READY_TO_CALL,
        PROCESS_SUCCES;

        public static State toState(String strState){
                try {
                        return valueOf(strState);
                }catch (Exception e){
                        return UNKNOWN_ERROR;
                }
        }
    }
