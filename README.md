# 2.14. Desafio - Implementando conta bancária com testes unitários

ContaBancariaTest

    class ContaBancariaTest {
    
        @Test
        void saque() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal("70.00"));
            conta.saque(new BigDecimal("50.01"));
            assertEquals(new BigDecimal("19.99"), conta.saldo());
        }
    
        @Test
        void saqueComValorZeradoFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(IllegalArgumentException.class, ()-> conta.saque(BigDecimal.ZERO));
        }
    
        @Test
        void saqueComValorNegativoFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(IllegalArgumentException.class, ()-> conta.saque(new BigDecimal("-10.0")));
        }
    
        @Test
        void saqueComValorMaiorFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(RuntimeException.class, ()-> conta.saque(new BigDecimal("20.0")));
        }
    
        @Test
        void saqueComValorIgualNaoFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            conta.saque(new BigDecimal("10.00"));
            assertEquals(new BigDecimal("0.00"), conta.saldo());
        }
    
        @Test
        void saqueComValorNullFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(IllegalArgumentException.class, ()-> conta.saque(null));
        }
    
        @Test
        void deposito() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            conta.deposito(BigDecimal.TEN);
            assertEquals(new BigDecimal("20"), conta.saldo());
        }
    
        @Test
        void depositoComValorZeradoFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(IllegalArgumentException.class, ()-> conta.deposito(BigDecimal.ZERO));
        }
    
        @Test
        void depositoComValorNegativoFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(IllegalArgumentException.class, ()-> conta.deposito(new BigDecimal("-10.0")));
        }
    
        @Test
        void depositoComValorNullFalha() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            assertThrows(IllegalArgumentException.class, ()-> conta.deposito(null));
        }
    
        @Test
        void saqueAposDeposito() {
            ContaBancaria conta = new ContaBancaria(BigDecimal.TEN);
            conta.deposito(BigDecimal.TEN);
            conta.saque(new BigDecimal("5"));
            assertEquals(new BigDecimal("15"), conta.saldo());
        }
    
        @Test
        void saldo() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal("29.90"));
            assertEquals(new BigDecimal("29.90"), conta.saldo());
        }
    
        @Test
        void criarContaComSaldoNullFalha() {
            assertThrows(IllegalArgumentException.class, ()-> new ContaBancaria(null));
        }
    }

---

ContaBancaria

    public class ContaBancaria {
    
        private BigDecimal saldo;
    
        public ContaBancaria(BigDecimal saldo) {
            if (saldo == null) {
                throw new IllegalArgumentException("Valor inválido");
            }
            this.saldo = saldo;
        }
    
        public void saque(BigDecimal valor) {
            if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Valor inválido");
            }
            if (this.saldo.compareTo(valor) < 0) {
                throw new RuntimeException("Saldo insuficiente");
            }
            this.saldo = this.saldo.subtract(valor);
        }
    
        public void deposito(BigDecimal valor) {
            if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Valor inválido");
            }
            this.saldo = this.saldo.add(valor);
        }
    
        public BigDecimal saldo() {
            return this.saldo;
        }
    }
