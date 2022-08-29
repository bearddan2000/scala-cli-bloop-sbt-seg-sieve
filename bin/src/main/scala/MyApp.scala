
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object MyApp {
def simpleSieve(limit: Int, prime: mutable.ListBuffer[Int]): Unit =
    {
        // bound is square root of "high"
        var bound:Int = java.lang.Math.sqrt(limit).toInt;

        var mark = new Array[Boolean](bound + 1);
        for (i <- 0 to bound)
            mark(i) = true;

        var x:Int = 2;
        while (x*x <= bound) {
            if (mark(x) == true) {
                var y:Int = x*x;
                while (y <= bound){
                    mark(x) = false;
                    y+=x;
                }
            }
            x+=1;
        }

        // adding primes to vector
        for (i <- 2 to bound) {
            if (mark(i) == true)
                prime += i;
        }
    }
    // Finds all prime numbers in range low to high
// using the primes we obtained from
// simple sieve
def segmentedSieve(low: Int, high: Int): Unit =
{
    val prime = mutable.ListBuffer[Int]();
    simpleSieve(high, prime); // stores primes upto
                              // sqrt(high) in prime

    var mark = new Array[Boolean](high - low + 1);
    for (i <- 0 to mark.length-1)
        mark(i) = true;

    for (i <- prime) {
        // find minimum number in [low...high]
        // that is multiple of prime[i]
        var loLim:Int = (low / i) * i;

        if (loLim < low)
            loLim += i;
        if (loLim == i)
            loLim += i;

        var j:Int = loLim;
        while (j <= high) {
            if (j != i)
                mark(j - low) = false;
            j += i;
        }
    }

    print("[OUTPUT] ");
    // print all primes in [low...high]
    for (i <- low to high) {
        if (mark(i - low) == true)
            print(i + " ");
    }
    println("");
  }
  def main(args: Array[String]): Unit = {
    var low:Int = 10;
    var high:Int = 20;
    println("[INPUT] low: " + low + "\thigh: " + high);
    segmentedSieve(low, high);
  }
}
