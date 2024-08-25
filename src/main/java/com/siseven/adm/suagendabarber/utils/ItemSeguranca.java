package com.siseven.adm.suagendabarber.utils;

import java.io.Serial;
import java.util.HashMap;

public class ItemSeguranca extends HashMap<Object, Object> {
        @Serial
        private static final long serialVersionUID = 1L;

        public ItemSeguranca(Object valor,Object seg) {
            this.put("valor", validarSegurancaCampo(valor,seg));
            this.put("seguranca", seg);
            this.put("disabled", validarSegurancaCampo(seg));
        }

        public ItemSeguranca(Object valor,Object seg, Object pendencia) {
            this.put("valor", validarSegurancaCampo(valor,seg, pendencia));
            this.put("pendencia", pendencia);
            this.put("seguranca", seg);
            this.put("disabled", validarSegurancaCampo(seg));
        }

        public ItemSeguranca(Object valor,Object descricao, Object seg, Object pendencia) {
            this.put("value", validarSegurancaCampo(valor,seg, pendencia));
            this.put("descricao", validarSegurancaCampo(descricao, seg, pendencia));
            this.put("pendencia", pendencia);
            this.put("seguranca", seg);
            this.put("disabled", validarSegurancaCampo(seg));
        }

        public ItemSeguranca(Object valor,Object descricao, Object seg, Object pendencia, Object habilitaFatca) {
            this.put("value", validarSegurancaCampo(valor,seg, pendencia));
            this.put("descricao", validarSegurancaCampo(descricao, seg, pendencia));
            this.put("pendencia", pendencia);
            this.put("seguranca", seg);
            this.put("disabled", validarSegurancaCampo(seg));
            this.put("habilitaFatca", habilitaFatca);
        }

        /**
         * @param seg
         * @return
         */
        private Boolean validarSegurancaCampo(Object seg) {
            if(seg != null) {
                String valor = seg.toString();
                return valor.equalsIgnoreCase("m");
            }
            return false;
        }


        /**
         * @param value
         * @param seg
         * @return
         */
        private Object validarSegurancaCampo(Object value, Object seg) {
            if(seg != null) {
                String sgr = seg.toString();
                if(sgr.equalsIgnoreCase("v")) {
                    return "*****";
                }
            }
            return value;
        }

        /**
         * @param value
         * @param seg
         * @param pendencia
         * @return
         */
        private Object validarSegurancaCampo(Object value, Object seg, Object pendencia) {
            if(seg != null) {
                String sgr = seg.toString();
                if(sgr.equalsIgnoreCase("v")) {
                    return "*****";
                }
                if(pendencia != null) {
                    return Boolean.TRUE.equals(pendencia) ? "" : value;
                }
            }
            return value;
        }



}
