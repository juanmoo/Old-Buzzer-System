int data = A0;
int clk = A1;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(data, OUTPUT);
  pinMode(clk, OUTPUT);n 

  delay(2000);
  for( int i = 0; i<5; i++) {
    digitalWrite(data, HIGH);
    digitalWrite(clk, HIGH);
    digitalWrite(clk, LOW);
    digitalWrite(data, LOW);
  }

  Serial.println("DONE");
}

void loop() {
  // put your main code here, to run repeatedly:
  if (Serial.available()>0) {
    Serial.println(Serial.read());

    Serial.println("End Of Transmission");
  }
}
