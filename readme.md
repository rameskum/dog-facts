# DOG API

This is the Dog API and it provides dog facts as a service dogdog 🐶

## Use it as an API

Live Endpoint: `https://dog-fact.herokuapp.com`

| Path                | Description                      | Parameters |
|---------------------|----------------------------------|------------|
| `/api/v1/facts/dog` | Returns an object with dog facts | `?count=5` |

### EXMAPLE

#### Single Fact

**Endpoint**: `https://dog-fact.herokuapp.com/api/v1/facts/dog` 

[link](https://dog-fact.herokuapp.com/api/v1/facts/dog)

**Response**:

```json
{
  "facts": [
    "Spiked dog collars were invented in ancient Greece and were originally designed to protect dogs throats from wolf attacks."
  ],
  "count": 1
}
```

#### Multiple Facts

**Endpoint**: `https://dog-fact.herokuapp.com/api/v1/facts/dog?count=5`

[link](https://dog-fact.herokuapp.com/api/v1/facts/dog?count=5)

**Response**:

```json
{
  "facts": [
    "The current world record for a Flyball race is 14.413 seconds, set by the team 'Touch N Go' of Las Vegas.",
    "Walt Disney's family dog -- named Sunnee -- was the inspiration behind 'Lady and the Tramp.'",
    "Humans have kept dogs as pets for over 12,000 years.",
    "Dogs have three eyelids. The third lid, called a nictitating membrane or 'haw,' keeps the eye lubricated and protected.",
    "The ancient Chinese carried Pekingese puppies in the sleeves of their robes."
  ],
  "count": 5
}
```

## CREDIT

This project is inspired by `https://github.com/kinduff/dog-api`
The project is rewritten in java.
